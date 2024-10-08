<script setup>
import { ref, computed, watchEffect } from 'vue'
import { useRouter, useData } from 'vitepress'

const { lang, isDark, page } = useData()
const router = useRouter()

const copied = ref(false)
const currentLang = ref('')

const shareLink = computed(() => {
  const currentPath = router.route.path
  return window.location.origin + currentPath.replace(/^\/[a-z]{2}\//, '/')
})

const isChinesePath = computed(() => {
  return page.value.relativePath.startsWith('zh/')
})

watchEffect(() => {
  currentLang.value = isChinesePath.value ? 'zh' : 'en'
})

const buttonText = computed(() => {
  return currentLang.value === 'zh' ? '复制分享链接' : 'Copy Share Link'
})

const copiedText = computed(() => {
  return currentLang.value === 'zh' ? '已复制！' : 'Copied!'
})

const copyLink = async () => {
  try {
    await navigator.clipboard.writeText(shareLink.value)
    copied.value = true
    setTimeout(() => {
      copied.value = false
    }, 2000)
  } catch (err) {
    console.error('Failed to copy: ', err)
  }
}
</script>

<template>
  <div class="share-link-container">
    <button @click="copyLink" class="share-link-button" :class="{ copied, 'dark-mode': isDark }">
      <span v-if="!copied">{{ buttonText }}</span>
      <span v-else>{{ copiedText }}</span>
    </button>
  </div>
</template>

<style scoped>
.share-link-container {
  padding: 16px;
  margin-bottom: 16px;
  border-bottom: 1px solid var(--vp-c-divider);
}

.share-link-button {
  background-color: #f5f5f5 !important;
  color: #333 !important;
  border: 1px solid #ccc !important;
  padding: 8px 16px;
  border-radius: 4px;
  cursor: pointer;
  font-weight: 500;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  font-size: 14px;
}

.share-link-button:hover {
  background-color: #e0e0e0 !important;
}

.share-link-button.copied {
  background-color: #4caf50 !important;
  color: white !important;
  border-color: #45a049 !important;
}

.share-link-container .dark-mode .share-link-button {
  background-color: #444 !important;
  color: #f0f0f0 !important;
  border: 1px solid #666 !important;
}

.share-link-container .dark-mode .share-link-button:hover {
  background-color: #555 !important;
}

.share-link-container .dark-mode .share-link-button.copied {
  background-color: #45a049 !important;
  color: white !important;
  border-color: #45a049 !important;
}

@media (max-width: 768px) {
  .share-link-container {
    padding: 12px;
  }
  .share-link-button {
    padding: 6px 12px;
    font-size: 12px;
  }
}
</style>
