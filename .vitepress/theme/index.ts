import { h } from 'vue'
import type { Theme } from 'vitepress'
import DefaultTheme from 'vitepress/theme'
import vitepressNprogress from 'vitepress-plugin-nprogress'
import 'vitepress-plugin-nprogress/lib/css/index.css'
import "vitepress-markdown-timeline/dist/theme/index.css";
import 'viewerjs/dist/viewer.min.css';
import { useData, useRoute } from 'vitepress';
import codeblocksFold from 'vitepress-plugin-codeblocks-fold';
import 'vitepress-plugin-codeblocks-fold/style/index.css';
import './style.css'
import { enhanceAppWithTabs } from 'vitepress-plugin-tabs/client'
import TwoslashFloatingVue from '@shikijs/vitepress-twoslash/client'
import '@shikijs/vitepress-twoslash/style.css'
import imageViewer from "./components/imageViewer.vue"
import vuetify from './vuetify'
import { onMounted, watch } from 'vue'
import mermaid from 'mermaid'
import AuthorsComponent from "./components/AuthorsComponent.vue";
import Layout from './Layout.vue'
import TdesignDark from './components/tdesignDark.vue'
import Comment from './components/comment.vue'
import YoutubeVideo from './components/YoutubeVideo.vue'
import BilibiliVideo from './components/BilibiliVideo.vue'
import damageChart from './components/minecraft-advanced-damage-chart.vue'
import carousel from './components/carousel.vue'
import ShareLinkButton from './components/ShareLinkButton.vue'
import '@mdit/plugin-spoiler/style'

export default {
  extends: DefaultTheme,
  Layout: () => {
    return h(DefaultTheme.Layout, null, {
      "doc-bottom": () => h(imageViewer),
      "layout-top": () => h(TdesignDark),
      "aside-outline-after": () => h(AuthorsComponent),
      "doc-after": () => h(Comment),
      "aside-outline-before": () => h(ShareLinkButton)
    })
  },
  enhanceApp: (ctx) => {
    DefaultTheme.enhanceApp(ctx);
    vitepressNprogress(ctx)
    enhanceAppWithTabs(ctx.app);
    ctx.app.use(vuetify);
    ctx.app.use(TwoslashFloatingVue);
    ctx.app.use(Layout);
    ctx.app.component('YoutubeVideo', YoutubeVideo)
    ctx.app.component('BilibiliVideo', BilibiliVideo)
    ctx.app.component('DamageChart', damageChart)
    ctx.app.component('Carousel', carousel)
  },
  setup() {
    const route = useRoute();
    const { frontmatter } = useData();
    codeblocksFold({ route, frontmatter }, true, 400);

    const initMermaid = () => {
      mermaid.initialize({
        startOnLoad: true,
        theme: 'default',
        securityLevel: 'loose',
        flowchart: { 
          useMaxWidth: true, 
          htmlLabels: true,
          curve: 'cardinal'
        },
        sequence: { 
          diagramMarginX: 50, 
          diagramMarginY: 10, 
          actorMargin: 50, 
          width: 150, 
          height: 65, 
          boxMargin: 10, 
          boxTextMargin: 5, 
          noteMargin: 10, 
          messageMargin: 35, 
          mirrorActors: true
        },
        gantt: {
          titleTopMargin: 25,
          barHeight: 20,
          barGap: 4,
          topPadding: 50,
          leftPadding: 75,
          gridLineStartPadding: 35,
          fontSize: 11,
          fontFamily: '"Open-Sans", "sans-serif"',
          numberSectionStyles: 4,
          axisFormat: '%Y-%m-%d'
        }
      });
    };

    onMounted(() => {
      initMermaid();
      mermaid.init(undefined, '.mermaid');

      watch(() => route.path, () => {
        setTimeout(() => {
          mermaid.init(undefined, '.mermaid');
        }, 100);
      });
    });
  }
} satisfies Theme