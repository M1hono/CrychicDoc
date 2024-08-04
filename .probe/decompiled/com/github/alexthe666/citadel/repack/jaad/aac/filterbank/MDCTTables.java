package com.github.alexthe666.citadel.repack.jaad.aac.filterbank;

interface MDCTTables {

    float[][] MDCT_TABLE_2048 = new float[][] { { 0.031249998F, 1.1984224E-5F }, { 0.031249814F, 1.0785781E-4F }, { 0.031249335F, 2.0373038E-4F }, { 0.031248564F, 2.9960103E-4F }, { 0.031247498F, 3.9546887E-4F }, { 0.031246137F, 4.9133296E-4F }, { 0.031244483F, 5.871925E-4F }, { 0.031242535F, 6.830464E-4F }, { 0.031240292F, 7.7889394E-4F }, { 0.031237755F, 8.7473413E-4F }, { 0.031234924F, 9.705661E-4F }, { 0.0312318F, 0.0010663889F }, { 0.03122838F, 0.0011622017F }, { 0.031224668F, 0.0012580036F }, { 0.031220661F, 0.0013537935F }, { 0.031216362F, 0.0014495709F }, { 0.031211767F, 0.0015453345F }, { 0.03120688F, 0.0016410836F }, { 0.031201698F, 0.0017368172F }, { 0.031196224F, 0.0018325346F }, { 0.031190453F, 0.0019282346F }, { 0.031184392F, 0.0020239165F }, { 0.031178035F, 0.0021195794F }, { 0.031171385F, 0.0022152222F }, { 0.031164443F, 0.0023108441F }, { 0.031157207F, 0.0024064444F }, { 0.031149678F, 0.002502022F }, { 0.031141855F, 0.0025975762F }, { 0.03113374F, 0.002693106F }, { 0.03112533F, 0.00278861F }, { 0.031116627F, 0.002884088F }, { 0.031107632F, 0.002979539F }, { 0.031098345F, 0.003074962F }, { 0.031088766F, 0.003170356F }, { 0.031078892F, 0.0032657199F }, { 0.031068727F, 0.0033610533F }, { 0.03105827F, 0.0034563548F }, { 0.03104752F, 0.003551624F }, { 0.031036478F, 0.00364686F }, { 0.031025143F, 0.0037420613F }, { 0.031013517F, 0.0038372274F }, { 0.031001598F, 0.0039323573F }, { 0.030989388F, 0.0040274505F }, { 0.030976886F, 0.004122506F }, { 0.030964091F, 0.004217522F }, { 0.030951008F, 0.0043124985F }, { 0.03093763F, 0.0044074347F }, { 0.030923964F, 0.0045023295F }, { 0.030910006F, 0.0045971815F }, { 0.030895757F, 0.0046919906F }, { 0.030881215F, 0.004786755F }, { 0.030866385F, 0.004881475F }, { 0.030851264F, 0.0049761487F }, { 0.030835852F, 0.0050707757F }, { 0.03082015F, 0.005165355F }, { 0.030804157F, 0.0052598855F }, { 0.030787876F, 0.0053543663F }, { 0.030771304F, 0.0054487973F }, { 0.030754441F, 0.0055431766F }, { 0.03073729F, 0.0056375037F }, { 0.03071985F, 0.0057317778F }, { 0.030702122F, 0.0058259983F }, { 0.030684102F, 0.0059201634F }, { 0.030665796F, 0.006014273F }, { 0.0306472F, 0.006108326F }, { 0.030628316F, 0.0062023215F }, { 0.030609142F, 0.006296259F }, { 0.030589683F, 0.0063901367F }, { 0.030569933F, 0.0064839544F }, { 0.030549897F, 0.006577711F }, { 0.030529574F, 0.006671406F }, { 0.030508962F, 0.006765038F }, { 0.030488063F, 0.0068586064F }, { 0.030466879F, 0.00695211F }, { 0.030445406F, 0.0070455484F }, { 0.030423647F, 0.0071389205F }, { 0.030401602F, 0.0072322255F }, { 0.030379271F, 0.007325462F }, { 0.030356653F, 0.0074186297F }, { 0.030333752F, 0.007511728F }, { 0.030310562F, 0.007604755F }, { 0.030287089F, 0.007697711F }, { 0.03026333F, 0.007790594F }, { 0.030239286F, 0.007883404F }, { 0.030214958F, 0.00797614F }, { 0.030190345F, 0.0080688F }, { 0.030165449F, 0.008161386F }, { 0.030140268F, 0.008253893F }, { 0.030114803F, 0.008346323F }, { 0.030089056F, 0.008438675F }, { 0.030063024F, 0.008530947F }, { 0.03003671F, 0.008623139F }, { 0.030010113F, 0.00871525F }, { 0.029983234F, 0.008807278F }, { 0.029956073F, 0.008899224F }, { 0.02992863F, 0.008991086F }, { 0.029900905F, 0.009082864F }, { 0.029872898F, 0.009174556F }, { 0.02984461F, 0.009266161F }, { 0.02981604F, 0.00935768F }, { 0.029787192F, 0.009449109F }, { 0.029758062F, 0.009540451F }, { 0.029728653F, 0.009631703F }, { 0.029698964F, 0.009722863F }, { 0.029668994F, 0.009813933F }, { 0.029638747F, 0.00990491F }, { 0.029608218F, 0.009995794F }, { 0.029577412F, 0.010086584F }, { 0.029546328F, 0.010177278F }, { 0.029514967F, 0.010267877F }, { 0.029483326F, 0.010358379F }, { 0.029451407F, 0.010448785F }, { 0.029419212F, 0.010539091F }, { 0.02938674F, 0.010629298F }, { 0.029353991F, 0.0107194055F }, { 0.029320966F, 0.010809411F }, { 0.029287666F, 0.0108993165F }, { 0.02925409F, 0.010989118F }, { 0.029220238F, 0.011078817F }, { 0.029186111F, 0.011168411F }, { 0.02915171F, 0.0112579F }, { 0.029117033F, 0.011347284F }, { 0.029082084F, 0.01143656F }, { 0.02904686F, 0.011525729F }, { 0.029011363F, 0.011614789F }, { 0.028975593F, 0.01170374F }, { 0.028939549F, 0.011792581F }, { 0.028903235F, 0.0118813105F }, { 0.028866647F, 0.011969929F }, { 0.028829789F, 0.012058434F }, { 0.028792657F, 0.012146826F }, { 0.028755257F, 0.012235103F }, { 0.028717585F, 0.012323265F }, { 0.028679641F, 0.012411311F }, { 0.028641429F, 0.012499241F }, { 0.028602947F, 0.012587053F }, { 0.028564196F, 0.012674746F }, { 0.028525176F, 0.01276232F }, { 0.028485889F, 0.012849774F }, { 0.028446332F, 0.012937107F }, { 0.028406506F, 0.013024318F }, { 0.028366415F, 0.013111407F }, { 0.028326057F, 0.013198372F }, { 0.02828543F, 0.013285213F }, { 0.02824454F, 0.0133719295F }, { 0.028203381F, 0.013458519F }, { 0.02816196F, 0.013544983F }, { 0.028120272F, 0.013631319F }, { 0.028078318F, 0.013717527F }, { 0.0280361F, 0.013803605F }, { 0.027993621F, 0.013889553F }, { 0.027950877F, 0.013975372F }, { 0.027907869F, 0.014061058F }, { 0.0278646F, 0.014146612F }, { 0.027821066F, 0.014232032F }, { 0.027777273F, 0.014317319F }, { 0.027733216F, 0.0144024715F }, { 0.0276889F, 0.014487488F }, { 0.027644323F, 0.014572368F }, { 0.027599486F, 0.014657111F }, { 0.02755439F, 0.014741716F }, { 0.027509032F, 0.014826182F }, { 0.027463416F, 0.014910509F }, { 0.027417542F, 0.014994696F }, { 0.02737141F, 0.015078741F }, { 0.02732502F, 0.015162644F }, { 0.027278373F, 0.015246404F }, { 0.02723147F, 0.015330022F }, { 0.02718431F, 0.015413495F }, { 0.027136894F, 0.015496822F }, { 0.027089221F, 0.015580004F }, { 0.027041296F, 0.015663039F }, { 0.026993115F, 0.015745927F }, { 0.02694468F, 0.015828667F }, { 0.026895992F, 0.015911257F }, { 0.02684705F, 0.015993698F }, { 0.026797855F, 0.01607599F }, { 0.02674841F, 0.016158128F }, { 0.02669871F, 0.016240114F }, { 0.026648762F, 0.01632195F }, { 0.026598562F, 0.016403629F }, { 0.02654811F, 0.016485155F }, { 0.026497409F, 0.016566526F }, { 0.02644646F, 0.016647741F }, { 0.026395261F, 0.0167288F }, { 0.026343813F, 0.0168097F }, { 0.026292117F, 0.016890442F }, { 0.026240176F, 0.016971026F }, { 0.026187984F, 0.01705145F }, { 0.026135549F, 0.017131714F }, { 0.026082866F, 0.017211815F }, { 0.026029939F, 0.017291756F }, { 0.025976766F, 0.017371533F }, { 0.025923347F, 0.017451147F }, { 0.025869686F, 0.017530596F }, { 0.025815781F, 0.017609881F }, { 0.025761634F, 0.017688999F }, { 0.025707243F, 0.017767953F }, { 0.025652612F, 0.017846737F }, { 0.025597738F, 0.017925354F }, { 0.025542622F, 0.018003803F }, { 0.025487268F, 0.018082082F }, { 0.025431672F, 0.01816019F }, { 0.02537584F, 0.01823813F }, { 0.025319764F, 0.018315895F }, { 0.025263453F, 0.018393489F }, { 0.025206905F, 0.01847091F }, { 0.025150118F, 0.018548155F }, { 0.025093095F, 0.018625228F }, { 0.025035836F, 0.018702125F }, { 0.02497834F, 0.018778846F }, { 0.024920609F, 0.01885539F }, { 0.024862645F, 0.018931756F }, { 0.024804447F, 0.019007945F }, { 0.024746014F, 0.019083954F }, { 0.024687348F, 0.019159785F }, { 0.024628451F, 0.019235434F }, { 0.024569321F, 0.019310903F }, { 0.02450996F, 0.019386189F }, { 0.02445037F, 0.019461293F }, { 0.024390548F, 0.019536214F }, { 0.024330497F, 0.01961095F }, { 0.024270218F, 0.019685503F }, { 0.024209708F, 0.019759871F }, { 0.024148973F, 0.019834053F }, { 0.024088008F, 0.019908046F }, { 0.024026819F, 0.019981854F }, { 0.023965402F, 0.020055473F }, { 0.02390376F, 0.020128904F }, { 0.023841891F, 0.020202145F }, { 0.0237798F, 0.020275196F }, { 0.023717485F, 0.020348055F }, { 0.023654947F, 0.020420725F }, { 0.023592185F, 0.0204932F }, { 0.023529202F, 0.020565484F }, { 0.023465998F, 0.020637574F }, { 0.023402572F, 0.02070947F }, { 0.023338927F, 0.02078117F }, { 0.02327506F, 0.020852676F }, { 0.023210976F, 0.020923983F }, { 0.023146672F, 0.020995095F }, { 0.023082152F, 0.02106601F }, { 0.023017414F, 0.021136725F }, { 0.022952458F, 0.021207243F }, { 0.022887288F, 0.02127756F }, { 0.022821901F, 0.021347677F }, { 0.0227563F, 0.021417594F }, { 0.022690484F, 0.021487307F }, { 0.022624455F, 0.02155682F }, { 0.022558214F, 0.02162613F }, { 0.02249176F, 0.021695236F }, { 0.022425095F, 0.021764137F }, { 0.022358216F, 0.021832833F }, { 0.02229113F, 0.021901324F }, { 0.022223832F, 0.02196961F }, { 0.022156326F, 0.022037689F }, { 0.022088611F, 0.02210556F }, { 0.022020688F, 0.022173222F }, { 0.021952558F, 0.022240676F }, { 0.021884222F, 0.022307921F }, { 0.021815678F, 0.022374956F }, { 0.02174693F, 0.02244178F }, { 0.021677978F, 0.022508394F }, { 0.02160882F, 0.022574795F }, { 0.02153946F, 0.022640983F }, { 0.021469899F, 0.02270696F }, { 0.021400133F, 0.02277272F }, { 0.021330167F, 0.022838268F }, { 0.021259999F, 0.0229036F }, { 0.021189632F, 0.022968717F }, { 0.021119066F, 0.023033619F }, { 0.0210483F, 0.023098303F }, { 0.020977337F, 0.02316277F }, { 0.020906175F, 0.023227017F }, { 0.020834817F, 0.023291048F }, { 0.020763263F, 0.023354858F }, { 0.020691514F, 0.023418449F }, { 0.02061957F, 0.02348182F }, { 0.020547431F, 0.023544969F }, { 0.020475099F, 0.023607897F }, { 0.020402575F, 0.023670603F }, { 0.02032986F, 0.023733085F }, { 0.020256951F, 0.023795344F }, { 0.020183852F, 0.02385738F }, { 0.020110564F, 0.023919191F }, { 0.020037087F, 0.023980778F }, { 0.01996342F, 0.024042137F }, { 0.019889567F, 0.02410327F }, { 0.019815525F, 0.024164177F }, { 0.019741297F, 0.024224857F }, { 0.019666882F, 0.024285309F }, { 0.019592285F, 0.024345532F }, { 0.019517502F, 0.024405524F }, { 0.019442534F, 0.024465289F }, { 0.019367384F, 0.024524823F }, { 0.019292051F, 0.024584126F }, { 0.019216537F, 0.024643198F }, { 0.019140843F, 0.024702037F }, { 0.019064968F, 0.024760643F }, { 0.018988915F, 0.024819018F }, { 0.01891268F, 0.024877159F }, { 0.018836271F, 0.024935065F }, { 0.01875968F, 0.024992736F }, { 0.018682918F, 0.025050173F }, { 0.018605975F, 0.025107373F }, { 0.01852886F, 0.025164336F }, { 0.01845157F, 0.025221065F }, { 0.018374106F, 0.025277553F }, { 0.018296469F, 0.025333805F }, { 0.01821866F, 0.02538982F }, { 0.01814068F, 0.025445594F }, { 0.018062528F, 0.025501128F }, { 0.017984206F, 0.025556425F }, { 0.017905716F, 0.025611479F }, { 0.017827056F, 0.025666293F }, { 0.01774823F, 0.025720865F }, { 0.017669236F, 0.025775194F }, { 0.017590076F, 0.025829282F }, { 0.01751075F, 0.025883125F }, { 0.01743126F, 0.025936725F }, { 0.017351603F, 0.025990082F }, { 0.017271785F, 0.026043193F }, { 0.017191805F, 0.026096059F }, { 0.017111663F, 0.02614868F }, { 0.017031359F, 0.026201056F }, { 0.016950896F, 0.026253184F }, { 0.016870271F, 0.026305065F }, { 0.01678949F, 0.026356699F }, { 0.01670855F, 0.026408084F }, { 0.016627451F, 0.02645922F }, { 0.016546197F, 0.026510108F }, { 0.016464788F, 0.026560746F }, { 0.016383223F, 0.026611134F }, { 0.016301505F, 0.026661273F }, { 0.016219633F, 0.026711158F }, { 0.016137607F, 0.026760794F }, { 0.016055431F, 0.026810179F }, { 0.015973102F, 0.02685931F }, { 0.015890624F, 0.026908187F }, { 0.015807996F, 0.026956813F }, { 0.01572522F, 0.027005184F }, { 0.015642295F, 0.027053302F }, { 0.015559223F, 0.027101165F }, { 0.015476004F, 0.027148772F }, { 0.01539264F, 0.027196124F }, { 0.015309131F, 0.02724322F }, { 0.015225478F, 0.02729006F }, { 0.015141682F, 0.027336642F }, { 0.015057743F, 0.027382966F }, { 0.014973662F, 0.027429035F }, { 0.0148894405F, 0.027474845F }, { 0.0148050785F, 0.027520396F }, { 0.014720578F, 0.027565686F }, { 0.014635938F, 0.02761072F }, { 0.014551161F, 0.027655492F }, { 0.014466247F, 0.027700003F }, { 0.014381196F, 0.027744256F }, { 0.01429601F, 0.027788246F }, { 0.01421069F, 0.027831974F }, { 0.014125235F, 0.027875442F }, { 0.014039649F, 0.027918646F }, { 0.013953929F, 0.027961588F }, { 0.013868079F, 0.028004266F }, { 0.013782097F, 0.02804668F }, { 0.013695987F, 0.028088832F }, { 0.0136097465F, 0.028130718F }, { 0.013523379F, 0.02817234F }, { 0.013436884F, 0.028213697F }, { 0.013350262F, 0.028254787F }, { 0.013263515F, 0.028295612F }, { 0.013176642F, 0.028336171F }, { 0.013089647F, 0.028376464F }, { 0.013002527F, 0.028416488F }, { 0.012915285F, 0.028456245F }, { 0.012827922F, 0.028495735F }, { 0.012740438F, 0.028534956F }, { 0.012652834F, 0.02857391F }, { 0.012565111F, 0.028612593F }, { 0.012477269F, 0.028651008F }, { 0.012389311F, 0.028689153F }, { 0.012301235F, 0.028727027F }, { 0.012213044F, 0.028764632F }, { 0.012124738F, 0.028801966F }, { 0.012036318F, 0.028839028F }, { 0.011947785F, 0.02887582F }, { 0.0118591385F, 0.02891234F }, { 0.011770381F, 0.028948586F }, { 0.011681512F, 0.028984562F }, { 0.011592534F, 0.029020263F }, { 0.011503447F, 0.029055692F }, { 0.01141425F, 0.029090848F }, { 0.011324948F, 0.029125728F }, { 0.011235538F, 0.029160336F }, { 0.011146022F, 0.029194668F }, { 0.011056402F, 0.029228726F }, { 0.010966677F, 0.02926251F }, { 0.010876849F, 0.029296018F }, { 0.01078692F, 0.02932925F }, { 0.010696888F, 0.029362205F }, { 0.0106067555F, 0.029394884F }, { 0.010516523F, 0.029427288F }, { 0.010426193F, 0.029459413F }, { 0.010335763F, 0.02949126F }, { 0.010245237F, 0.029522832F }, { 0.010154613F, 0.029554125F }, { 0.010063895F, 0.02958514F }, { 0.009973082F, 0.029615877F }, { 0.009882174F, 0.029646333F }, { 0.009791174F, 0.029676512F }, { 0.009700082F, 0.029706411F }, { 0.009608898F, 0.02973603F }, { 0.009517624F, 0.029765371F }, { 0.00942626F, 0.02979443F }, { 0.009334808F, 0.02982321F }, { 0.009243268F, 0.029851709F }, { 0.00915164F, 0.029879926F }, { 0.009059927F, 0.029907862F }, { 0.008968129F, 0.029935516F }, { 0.0088762455F, 0.02996289F }, { 0.008784279F, 0.02998998F }, { 0.00869223F, 0.03001679F }, { 0.008600098F, 0.030043315F }, { 0.008507887F, 0.030069558F }, { 0.008415595F, 0.03009552F }, { 0.008323223F, 0.030121196F }, { 0.008230773F, 0.03014659F }, { 0.008138246F, 0.0301717F }, { 0.008045643F, 0.030196525F }, { 0.007952963F, 0.030221067F }, { 0.007860209F, 0.030245325F }, { 0.00776738F, 0.030269297F }, { 0.0076744785F, 0.030292984F }, { 0.007581505F, 0.030316386F }, { 0.00748846F, 0.030339504F }, { 0.0073953443F, 0.030362334F }, { 0.0073021594F, 0.030384881F }, { 0.0072089056F, 0.03040714F }, { 0.007115584F, 0.030429114F }, { 0.007022195F, 0.0304508F }, { 0.00692874F, 0.030472202F }, { 0.0068352204F, 0.030493315F }, { 0.006741636F, 0.030514142F }, { 0.006647988F, 0.030534681F }, { 0.0065542776F, 0.030554933F }, { 0.0064605055F, 0.030574897F }, { 0.006366673F, 0.030594574F }, { 0.00627278F, 0.030613963F }, { 0.006178828F, 0.030633064F }, { 0.0060848184F, 0.030651875F }, { 0.005990751F, 0.030670399F }, { 0.0058966274F, 0.030688634F }, { 0.005802448F, 0.03070658F }, { 0.0057082144F, 0.030724239F }, { 0.005613927F, 0.030741606F }, { 0.0055195866F, 0.030758685F }, { 0.0054251943F, 0.030775474F }, { 0.0053307507F, 0.030791974F }, { 0.0052362573F, 0.030808182F }, { 0.0051417146F, 0.030824102F }, { 0.0050471234F, 0.030839732F }, { 0.0049524847F, 0.03085507F }, { 0.004857799F, 0.03087012F }, { 0.004763068F, 0.030884879F }, { 0.004668292F, 0.030899346F }, { 0.0045734723F, 0.030913522F }, { 0.0044786097F, 0.030927408F }, { 0.0043837046F, 0.030941002F }, { 0.004288758F, 0.030954305F }, { 0.0041937716F, 0.030967318F }, { 0.0040987455F, 0.03098004F }, { 0.004003681F, 0.030992467F }, { 0.0039085783F, 0.031004604F }, { 0.0038134393F, 0.03101645F }, { 0.0037182642F, 0.031028004F }, { 0.0036230541F, 0.031039266F }, { 0.0035278099F, 0.031050235F }, { 0.0034325325F, 0.031060912F }, { 0.0033372228F, 0.031071296F }, { 0.0032418817F, 0.031081388F }, { 0.00314651F, 0.031091187F }, { 0.003051109F, 0.031100696F }, { 0.0029556789F, 0.031109909F }, { 0.002860221F, 0.03111883F }, { 0.0027647365F, 0.03112746F }, { 0.0026692257F, 0.031135796F }, { 0.00257369F, 0.031143837F }, { 0.00247813F, 0.031151587F }, { 0.0023825464F, 0.031159043F }, { 0.0022869406F, 0.031166205F }, { 0.0021913133F, 0.031173076F }, { 0.0020956653F, 0.031179652F }, { 0.0019999978F, 0.031185934F }, { 0.0019043112F, 0.031191923F }, { 0.0018086068F, 0.031197619F }, { 0.0017128853F, 0.03120302F }, { 0.0016171477F, 0.03120813F }, { 0.0015213949F, 0.031212945F }, { 0.0014256279F, 0.031217465F }, { 0.0013298473F, 0.031221692F }, { 0.0012340542F, 0.031225624F }, { 0.0011382495F, 0.031229263F }, { 0.0010424341F, 0.031232608F }, { 9.4660895E-4F, 0.03123566F }, { 8.507748E-4F, 0.031238416F }, { 7.549327E-4F, 0.03124088F }, { 6.590835E-4F, 0.031243049F }, { 5.632281E-4F, 0.031244924F }, { 4.6736735E-4F, 0.031246506F }, { 3.7150222E-4F, 0.03124779F }, { 2.756336E-4F, 0.031248784F }, { 1.7976238E-4F, 0.031249482F }, { 8.388947E-5F, 0.031249888F } };

    float[][] MDCT_TABLE_128 = new float[][] { { 0.08838793F, 2.7117162E-4F }, { 0.088354655F, 0.0024402384F }, { 0.08826816F, 0.0046078353F }, { 0.08812849F, 0.0067726565F }, { 0.08793574F, 0.008933398F }, { 0.08769002F, 0.011088759F }, { 0.08739147F, 0.01323744F }, { 0.08704029F, 0.015378147F }, { 0.08663668F, 0.01750959F }, { 0.08618088F, 0.019630488F }, { 0.08567317F, 0.021739561F }, { 0.085113846F, 0.023835538F }, { 0.08450326F, 0.025917158F }, { 0.08384177F, 0.027983164F }, { 0.08312978F, 0.030032318F }, { 0.08236771F, 0.03206338F }, { 0.08155603F, 0.034075126F }, { 0.08069522F, 0.03606635F }, { 0.0797858F, 0.038035847F }, { 0.07882833F, 0.039982434F }, { 0.07782337F, 0.041904934F }, { 0.07677153F, 0.043802194F }, { 0.075673446F, 0.04567307F }, { 0.07452978F, 0.04751643F }, { 0.07334123F, 0.049331173F }, { 0.072108485F, 0.051116202F }, { 0.07083231F, 0.052870438F }, { 0.06951348F, 0.054592825F }, { 0.06815276F, 0.05628233F }, { 0.066751F, 0.05793793F }, { 0.06530903F, 0.059558634F }, { 0.063827716F, 0.061143458F }, { 0.062307958F, 0.06269145F }, { 0.060750667F, 0.06420168F }, { 0.059156783F, 0.06567325F }, { 0.057527263F, 0.06710525F }, { 0.055863094F, 0.06849682F }, { 0.05416527F, 0.069847144F }, { 0.05243482F, 0.07115539F }, { 0.05067279F, 0.072420776F }, { 0.048880234F, 0.07364254F }, { 0.047058232F, 0.07481994F }, { 0.045207888F, 0.07595227F }, { 0.043330308F, 0.07703885F }, { 0.04142663F, 0.07807902F }, { 0.039497998F, 0.07907217F }, { 0.037545573F, 0.080017686F }, { 0.035570532F, 0.080915F }, { 0.033574067F, 0.08176357F }, { 0.031557377F, 0.08256289F }, { 0.029521678F, 0.08331249F }, { 0.027468195F, 0.08401189F }, { 0.025398167F, 0.084660694F }, { 0.02331284F, 0.0852585F }, { 0.02121347F, 0.08580495F }, { 0.019101324F, 0.08629971F }, { 0.01697767F, 0.08674248F }, { 0.014843788F, 0.08713301F }, { 0.012700967F, 0.08747105F }, { 0.010550494F, 0.08775641F }, { 0.008393667F, 0.0879889F }, { 0.006231783F, 0.08816839F }, { 0.004066145F, 0.08829477F }, { 0.0018980585F, 0.08836797F } };

    float[][] MDCT_TABLE_1920 = new float[][] { { 0.032274857F, 1.3202404E-5F }, { 0.03227464F, 1.1882137E-4F }, { 0.032274082F, 2.2443906E-4F }, { 0.032273173F, 3.3005435E-4F }, { 0.03227192F, 4.3566612E-4F }, { 0.032270323F, 5.412732E-4F }, { 0.03226838F, 6.468745E-4F }, { 0.032266088F, 7.524689E-4F }, { 0.032263454F, 8.580552E-4F }, { 0.032260474F, 9.636323E-4F }, { 0.032257147F, 0.0010691991F }, { 0.032253474F, 0.0011747545F }, { 0.032249458F, 0.0012802972F }, { 0.032245096F, 0.0013858263F }, { 0.032240387F, 0.0014913405F }, { 0.032235336F, 0.0015968387F }, { 0.032229938F, 0.00170232F }, { 0.032224193F, 0.0018077828F }, { 0.032218102F, 0.0019132263F }, { 0.03221167F, 0.0020186494F }, { 0.032204892F, 0.0021240509F }, { 0.03219777F, 0.0022294295F }, { 0.0321903F, 0.0023347845F }, { 0.03218249F, 0.0024401143F }, { 0.03217433F, 0.002545418F }, { 0.03216583F, 0.0026506945F }, { 0.03215698F, 0.0027559423F }, { 0.03214779F, 0.002861161F }, { 0.032138254F, 0.0029663488F }, { 0.032128375F, 0.0030715049F }, { 0.032118153F, 0.0031766281F }, { 0.032107584F, 0.0032817174F }, { 0.032096673F, 0.0033867715F }, { 0.03208542F, 0.0034917893F }, { 0.03207382F, 0.0035967696F }, { 0.03206188F, 0.0037017115F }, { 0.032049593F, 0.0038066139F }, { 0.032036964F, 0.003911475F }, { 0.032023992F, 0.0040162946F }, { 0.03201068F, 0.004121071F }, { 0.031997018F, 0.004225804F }, { 0.031983018F, 0.004330491F }, { 0.031968676F, 0.004435132F }, { 0.03195399F, 0.0045397254F }, { 0.031938963F, 0.00464427F }, { 0.031923596F, 0.004748765F }, { 0.031907883F, 0.004853209F }, { 0.03189183F, 0.004957601F }, { 0.031875435F, 0.0050619403F }, { 0.0318587F, 0.005166225F }, { 0.031841625F, 0.0052704546F }, { 0.031824205F, 0.0053746277F }, { 0.031806447F, 0.005478743F }, { 0.031788345F, 0.0055827997F }, { 0.03176991F, 0.0056867967F }, { 0.031751126F, 0.005790733F }, { 0.031732008F, 0.005894607F }, { 0.031712547F, 0.005998418F }, { 0.031692747F, 0.0061021647F }, { 0.031672608F, 0.006205846F }, { 0.03165213F, 0.0063094613F }, { 0.031631313F, 0.0064130086F }, { 0.031610157F, 0.0065164873F }, { 0.031588662F, 0.0066198963F }, { 0.031566832F, 0.0067232344F }, { 0.03154466F, 0.0068265004F }, { 0.03152215F, 0.0069296933F }, { 0.031499304F, 0.007032812F }, { 0.03147612F, 0.0071358555F }, { 0.0314526F, 0.0072388225F }, { 0.031428743F, 0.007341712F }, { 0.03140455F, 0.007444523F }, { 0.03138002F, 0.0075472537F }, { 0.031355154F, 0.007649904F }, { 0.031329952F, 0.0077524725F }, { 0.031304415F, 0.007854958F }, { 0.03127854F, 0.007957359F }, { 0.031252332F, 0.008059675F }, { 0.031225791F, 0.008161904F }, { 0.031198913F, 0.008264047F }, { 0.031171702F, 0.0083661005F }, { 0.031144157F, 0.0084680645F }, { 0.031116279F, 0.008569938F }, { 0.031088067F, 0.00867172F }, { 0.031059522F, 0.008773409F }, { 0.031030646F, 0.008875004F }, { 0.031001436F, 0.008976503F }, { 0.030971894F, 0.009077908F }, { 0.030942021F, 0.009179214F }, { 0.030911816F, 0.009280422F }, { 0.030881282F, 0.009381531F }, { 0.030850416F, 0.009482539F }, { 0.030819219F, 0.009583446F }, { 0.030787691F, 0.00968425F }, { 0.030755835F, 0.009784951F }, { 0.03072365F, 0.009885546F }, { 0.030691134F, 0.009986036F }, { 0.030658292F, 0.010086419F }, { 0.03062512F, 0.010186694F }, { 0.03059162F, 0.010286859F }, { 0.030557793F, 0.010386915F }, { 0.030523637F, 0.01048686F }, { 0.030489156F, 0.010586691F }, { 0.030454349F, 0.01068641F }, { 0.030419214F, 0.010786015F }, { 0.030383755F, 0.010885503F }, { 0.030347968F, 0.010984875F }, { 0.030311858F, 0.01108413F }, { 0.030275423F, 0.011183266F }, { 0.030238664F, 0.011282281F }, { 0.03020158F, 0.011381176F }, { 0.030164175F, 0.01147995F }, { 0.030126445F, 0.0115786F }, { 0.030088393F, 0.011677126F }, { 0.030050019F, 0.011775528F }, { 0.030011322F, 0.011873803F }, { 0.029972306F, 0.011971951F }, { 0.029932966F, 0.012069971F }, { 0.029893307F, 0.012167862F }, { 0.029853327F, 0.012265622F }, { 0.029813029F, 0.012363251F }, { 0.02977241F, 0.012460748F }, { 0.029731473F, 0.012558111F }, { 0.029690217F, 0.012655339F }, { 0.029648645F, 0.012752432F }, { 0.029606754F, 0.012849389F }, { 0.029564546F, 0.012946208F }, { 0.02952202F, 0.013042888F }, { 0.029479181F, 0.013139429F }, { 0.029436024F, 0.013235829F }, { 0.029392552F, 0.013332087F }, { 0.029348766F, 0.013428202F }, { 0.029304665F, 0.013524174F }, { 0.02926025F, 0.01362F }, { 0.029215522F, 0.013715681F }, { 0.029170481F, 0.013811215F }, { 0.029125128F, 0.013906601F }, { 0.029079463F, 0.014001838F }, { 0.029033488F, 0.014096925F }, { 0.028987199F, 0.014191861F }, { 0.028940601F, 0.014286646F }, { 0.028893694F, 0.014381277F }, { 0.028846476F, 0.014475754F }, { 0.02879895F, 0.014570076F }, { 0.028751116F, 0.014664243F }, { 0.028702972F, 0.014758252F }, { 0.028654523F, 0.014852103F }, { 0.028605767F, 0.014945795F }, { 0.028556703F, 0.015039327F }, { 0.028507335F, 0.015132697F }, { 0.02845766F, 0.015225907F }, { 0.028407682F, 0.0153189525F }, { 0.028357398F, 0.015411834F }, { 0.028306812F, 0.015504551F }, { 0.02825592F, 0.015597101F }, { 0.02820473F, 0.015689485F }, { 0.028153235F, 0.0157817F }, { 0.028101439F, 0.015873747F }, { 0.02804934F, 0.015965624F }, { 0.027996944F, 0.01605733F }, { 0.027944246F, 0.016148863F }, { 0.02789125F, 0.016240224F }, { 0.027837954F, 0.01633141F }, { 0.02778436F, 0.016422423F }, { 0.02773047F, 0.016513258F }, { 0.027676282F, 0.016603917F }, { 0.027621798F, 0.016694399F }, { 0.027567018F, 0.016784701F }, { 0.027511943F, 0.016874824F }, { 0.027456572F, 0.016964767F }, { 0.027400909F, 0.017054526F }, { 0.027344951F, 0.017144104F }, { 0.027288701F, 0.017233498F }, { 0.027232159F, 0.017322708F }, { 0.027175324F, 0.017411733F }, { 0.027118199F, 0.01750057F }, { 0.027060783F, 0.01758922F }, { 0.027003078F, 0.017677682F }, { 0.026945084F, 0.017765954F }, { 0.0268868F, 0.017854037F }, { 0.02682823F, 0.017941928F }, { 0.026769372F, 0.018029626F }, { 0.026710225F, 0.018117134F }, { 0.026650794F, 0.018204445F }, { 0.026591077F, 0.018291561F }, { 0.026531076F, 0.018378483F }, { 0.026470792F, 0.018465206F }, { 0.026410222F, 0.018551733F }, { 0.026349371F, 0.018638061F }, { 0.026288237F, 0.01872419F }, { 0.026226822F, 0.018810118F }, { 0.026165126F, 0.018895842F }, { 0.026103148F, 0.018981367F }, { 0.026040893F, 0.019066688F }, { 0.025978358F, 0.019151803F }, { 0.025915544F, 0.019236716F }, { 0.025852455F, 0.019321421F }, { 0.025789086F, 0.019405918F }, { 0.025725443F, 0.019490208F }, { 0.025661524F, 0.01957429F }, { 0.02559733F, 0.019658163F }, { 0.025532862F, 0.019741824F }, { 0.02546812F, 0.019825274F }, { 0.025403107F, 0.019908514F }, { 0.025337819F, 0.019991538F }, { 0.025272261F, 0.020074349F }, { 0.025206434F, 0.020156944F }, { 0.025140336F, 0.020239323F }, { 0.025073968F, 0.020321487F }, { 0.025007332F, 0.020403432F }, { 0.024940427F, 0.020485159F }, { 0.024873257F, 0.020566666F }, { 0.02480582F, 0.020647954F }, { 0.024738116F, 0.02072902F }, { 0.024670148F, 0.020809865F }, { 0.024601916F, 0.020890485F }, { 0.02453342F, 0.020970883F }, { 0.024464663F, 0.021051057F }, { 0.024395643F, 0.021131003F }, { 0.02432636F, 0.021210724F }, { 0.024256818F, 0.021290218F }, { 0.024187017F, 0.021369485F }, { 0.024116956F, 0.021448523F }, { 0.024046637F, 0.02152733F }, { 0.02397606F, 0.021605907F }, { 0.023905227F, 0.021684252F }, { 0.023834137F, 0.021762365F }, { 0.023762792F, 0.021840246F }, { 0.023691194F, 0.021917893F }, { 0.02361934F, 0.021995304F }, { 0.023547234F, 0.022072481F }, { 0.023474876F, 0.022149421F }, { 0.023402268F, 0.022226123F }, { 0.023329407F, 0.022302588F }, { 0.023256298F, 0.022378813F }, { 0.023182938F, 0.0224548F }, { 0.023109332F, 0.022530545F }, { 0.023035476F, 0.022606049F }, { 0.022961376F, 0.022681313F }, { 0.022887029F, 0.02275633F }, { 0.022812435F, 0.022831107F }, { 0.0227376F, 0.022905638F }, { 0.022662519F, 0.022979924F }, { 0.022587197F, 0.023053963F }, { 0.022511631F, 0.023127757F }, { 0.022435825F, 0.023201302F }, { 0.02235978F, 0.023274599F }, { 0.022283494F, 0.023347646F }, { 0.02220697F, 0.023420444F }, { 0.022130208F, 0.02349299F }, { 0.022053208F, 0.023565285F }, { 0.021975974F, 0.023637328F }, { 0.021898502F, 0.023709117F }, { 0.021820799F, 0.023780653F }, { 0.02174286F, 0.023851933F }, { 0.021664688F, 0.02392296F }, { 0.021586284F, 0.023993729F }, { 0.021507649F, 0.024064241F }, { 0.021428784F, 0.024134494F }, { 0.02134969F, 0.02420449F }, { 0.021270366F, 0.024274228F }, { 0.021190817F, 0.024343705F }, { 0.021111038F, 0.024412923F }, { 0.021031033F, 0.024481876F }, { 0.020950805F, 0.024550568F }, { 0.02087035F, 0.024618998F }, { 0.020789674F, 0.024687165F }, { 0.020708775F, 0.024755066F }, { 0.020627653F, 0.024822703F }, { 0.02054631F, 0.024890075F }, { 0.020464748F, 0.024957178F }, { 0.020382967F, 0.025024015F }, { 0.020300966F, 0.025090585F }, { 0.020218749F, 0.025156885F }, { 0.020136315F, 0.025222916F }, { 0.020053666F, 0.025288677F }, { 0.0199708F, 0.025354166F }, { 0.019887723F, 0.025419384F }, { 0.019804433F, 0.025484331F }, { 0.019720929F, 0.025549004F }, { 0.019637214F, 0.025613405F }, { 0.01955329F, 0.02567753F }, { 0.019469157F, 0.02574138F }, { 0.019384814F, 0.025804954F }, { 0.019300263F, 0.025868252F }, { 0.019215506F, 0.025931275F }, { 0.019130545F, 0.025994018F }, { 0.019045377F, 0.026056483F }, { 0.018960005F, 0.02611867F }, { 0.018874431F, 0.026180577F }, { 0.018788654F, 0.026242202F }, { 0.018702677F, 0.026303547F }, { 0.018616498F, 0.02636461F }, { 0.018530121F, 0.026425391F }, { 0.018443543F, 0.02648589F }, { 0.01835677F, 0.026546104F }, { 0.018269802F, 0.026606034F }, { 0.018182635F, 0.02666568F }, { 0.018095275F, 0.026725039F }, { 0.01800772F, 0.026784113F }, { 0.017919973F, 0.0268429F }, { 0.017832035F, 0.026901398F }, { 0.017743904F, 0.02695961F }, { 0.017655585F, 0.027017532F }, { 0.017567076F, 0.027075164F }, { 0.017478378F, 0.027132507F }, { 0.017389493F, 0.02718956F }, { 0.017300423F, 0.02724632F }, { 0.017211167F, 0.02730279F }, { 0.017121727F, 0.027358968F }, { 0.017032104F, 0.027414853F }, { 0.016942298F, 0.027470443F }, { 0.01685231F, 0.02752574F }, { 0.016762143F, 0.02758074F }, { 0.016671795F, 0.027635446F }, { 0.016581269F, 0.027689857F }, { 0.016490566F, 0.027743971F }, { 0.016399685F, 0.027797787F }, { 0.01630863F, 0.027851306F }, { 0.0162174F, 0.027904527F }, { 0.016125996F, 0.027957449F }, { 0.016034419F, 0.02801007F }, { 0.01594267F, 0.028062394F }, { 0.01585075F, 0.028114416F }, { 0.015758662F, 0.028166136F }, { 0.015666405F, 0.028217556F }, { 0.015573979F, 0.028268673F }, { 0.015481387F, 0.028319487F }, { 0.015388629F, 0.028369997F }, { 0.015295706F, 0.028420204F }, { 0.015202619F, 0.028470108F }, { 0.01510937F, 0.028519705F }, { 0.015015959F, 0.028568998F }, { 0.014922387F, 0.028617984F }, { 0.014828655F, 0.028666664F }, { 0.014734765F, 0.028715037F }, { 0.014640716F, 0.028763102F }, { 0.014546511F, 0.02881086F }, { 0.014452149F, 0.02885831F }, { 0.014357634F, 0.02890545F }, { 0.014262964F, 0.02895228F }, { 0.014168141F, 0.0289988F }, { 0.014073168F, 0.02904501F }, { 0.013978043F, 0.02909091F }, { 0.013882768F, 0.029136496F }, { 0.013787345F, 0.029181771F }, { 0.013691775F, 0.029226733F }, { 0.013596057F, 0.029271383F }, { 0.013500194F, 0.02931572F }, { 0.013404187F, 0.029359741F }, { 0.013308035F, 0.02940345F }, { 0.013211742F, 0.029446842F }, { 0.013115306F, 0.02948992F }, { 0.013018731F, 0.029532682F }, { 0.012922016F, 0.029575128F }, { 0.012825162F, 0.029617256F }, { 0.012728171F, 0.029659068F }, { 0.012631045F, 0.029700562F }, { 0.012533782F, 0.029741738F }, { 0.012436386F, 0.029782595F }, { 0.012338856F, 0.029823134F }, { 0.012241194F, 0.029863352F }, { 0.012143401F, 0.029903252F }, { 0.012045478F, 0.029942831F }, { 0.011947426F, 0.02998209F }, { 0.011849246F, 0.030021027F }, { 0.011750939F, 0.030059641F }, { 0.011652507F, 0.030097935F }, { 0.01155395F, 0.030135907F }, { 0.011455269F, 0.030173557F }, { 0.011356465F, 0.030210882F }, { 0.011257539F, 0.030247884F }, { 0.011158492F, 0.030284563F }, { 0.011059327F, 0.030320916F }, { 0.010960043F, 0.030356945F }, { 0.0108606415F, 0.030392649F }, { 0.010761124F, 0.030428028F }, { 0.010661491F, 0.03046308F }, { 0.010561744F, 0.030497806F }, { 0.010461884F, 0.030532207F }, { 0.010361912F, 0.030566279F }, { 0.010261828F, 0.030600024F }, { 0.0101616355F, 0.030633444F }, { 0.010061333F, 0.030666532F }, { 0.009960923F, 0.030699294F }, { 0.009860408F, 0.030731726F }, { 0.009759786F, 0.030763831F }, { 0.009659058F, 0.030795604F }, { 0.009558229F, 0.03082705F }, { 0.009457297F, 0.030858163F }, { 0.009356263F, 0.030888947F }, { 0.009255129F, 0.0309194F }, { 0.009153896F, 0.030949522F }, { 0.009052565F, 0.030979311F }, { 0.008951138F, 0.03100877F }, { 0.008849614F, 0.031037897F }, { 0.008747996F, 0.03106669F }, { 0.008646283F, 0.03109515F }, { 0.008544479F, 0.03112328F }, { 0.008442583F, 0.031151075F }, { 0.008340595F, 0.031178536F }, { 0.00823852F, 0.031205663F }, { 0.008136355F, 0.031232458F }, { 0.008034104F, 0.031258915F }, { 0.007931766F, 0.03128504F }, { 0.007829344F, 0.03131083F }, { 0.007726838F, 0.03133628F }, { 0.007624249F, 0.0313614F }, { 0.0075215786F, 0.031386185F }, { 0.007418827F, 0.03141063F }, { 0.0073159966F, 0.03143474F }, { 0.0072130878F, 0.031458512F }, { 0.0071101016F, 0.031481948F }, { 0.007007039F, 0.03150505F }, { 0.006903902F, 0.03152781F }, { 0.0068006907F, 0.031550232F }, { 0.0066974065F, 0.03157232F }, { 0.0065940507F, 0.031594068F }, { 0.006490624F, 0.031615477F }, { 0.006387128F, 0.03163655F }, { 0.006283564F, 0.031657282F }, { 0.006179932F, 0.031677675F }, { 0.0060762344F, 0.031697728F }, { 0.0059724716F, 0.031717446F }, { 0.0058686445F, 0.031736817F }, { 0.005764755F, 0.031755853F }, { 0.005660803F, 0.03177455F }, { 0.005556791F, 0.031792905F }, { 0.0054527195F, 0.031810917F }, { 0.0053485897F, 0.031828593F }, { 0.005244402F, 0.031845924F }, { 0.005140159F, 0.031862915F }, { 0.0050358605F, 0.031879567F }, { 0.004931508F, 0.031895876F }, { 0.0048271026F, 0.031911843F }, { 0.004722646F, 0.03192747F }, { 0.004618138F, 0.03194275F }, { 0.0045135813F, 0.031957693F }, { 0.004408976F, 0.031972293F }, { 0.0043043233F, 0.03198655F }, { 0.004199625F, 0.032000467F }, { 0.0040948815F, 0.03201404F }, { 0.0039900937F, 0.032027267F }, { 0.0038852638F, 0.032040153F }, { 0.003780392F, 0.032052696F }, { 0.0036754797F, 0.032064896F }, { 0.003570528F, 0.03207675F }, { 0.0034655381F, 0.032088265F }, { 0.0033605113F, 0.032099433F }, { 0.0032554483F, 0.03211026F }, { 0.0031503504F, 0.032120742F }, { 0.003045219F, 0.03213088F }, { 0.0029400548F, 0.032140672F }, { 0.002834859F, 0.03215012F }, { 0.0027296331F, 0.032159224F }, { 0.0026243778F, 0.032167986F }, { 0.0025190946F, 0.0321764F }, { 0.0024137842F, 0.032184474F }, { 0.002308448F, 0.0321922F }, { 0.002203087F, 0.03219958F }, { 0.0020977026F, 0.032206617F }, { 0.0019922957F, 0.03221331F }, { 0.0018868673F, 0.03221966F }, { 0.0017814188F, 0.03222566F }, { 0.0016759513F, 0.03223132F }, { 0.0015704657F, 0.03223663F }, { 0.0014649634F, 0.032241598F }, { 0.0013594454F, 0.032246217F }, { 0.0012539128F, 0.032250494F }, { 0.0011483667F, 0.032254424F }, { 0.0010428084F, 0.03225801F }, { 9.372389E-4F, 0.03226125F }, { 8.316594E-4F, 0.032264143F }, { 7.26071E-4F, 0.03226669F }, { 6.204748E-4F, 0.032268897F }, { 5.1487196E-4F, 0.032270756F }, { 4.0926356E-4F, 0.032272268F }, { 3.0365083E-4F, 0.032273434F }, { 1.9803483E-4F, 0.032274254F }, { 9.24167E-5F, 0.03227473F } };

    float[][] MDCT_TABLE_240 = new float[][] { { 0.09128661F, 2.9873577E-4F }, { 0.0912475F, 0.0026882382F }, { 0.091145866F, 0.005075898F }, { 0.09098176F, 0.007460079F }, { 0.0907553F, 0.009839147F }, { 0.09046664F, 0.012211473F }, { 0.09011598F, 0.014575429F }, { 0.08970356F, 0.016929395F }, { 0.089229666F, 0.01927176F }, { 0.08869461F, 0.021600917F }, { 0.08809877F, 0.023915268F }, { 0.087442555F, 0.02621323F }, { 0.086726405F, 0.028493227F }, { 0.08595082F, 0.030753694F }, { 0.08511633F, 0.032993086F }, { 0.0842235F, 0.035209868F }, { 0.08327296F, 0.037402514F }, { 0.08226534F, 0.03956953F }, { 0.08120134F, 0.041709427F }, { 0.08008169F, 0.04382074F }, { 0.07890715F, 0.045902014F }, { 0.07767854F, 0.047951832F }, { 0.07639668F, 0.04996879F }, { 0.075062476F, 0.051951498F }, { 0.073676825F, 0.053898603F }, { 0.07224067F, 0.055808768F }, { 0.07075501F, 0.05768068F }, { 0.06922086F, 0.059513066F }, { 0.06763928F, 0.061304666F }, { 0.066011325F, 0.06305425F }, { 0.06433814F, 0.06476062F }, { 0.062620856F, 0.0664226F }, { 0.060860656F, 0.06803906F }, { 0.05905875F, 0.06960889F }, { 0.05721636F, 0.07113101F }, { 0.05533476F, 0.07260439F }, { 0.05341524F, 0.07402801F }, { 0.051459108F, 0.07540089F }, { 0.04946771F, 0.07672209F }, { 0.047442406F, 0.07799071F }, { 0.04538459F, 0.079205886F }, { 0.04329567F, 0.080366775F }, { 0.041177075F, 0.08147258F }, { 0.03903026F, 0.082522556F }, { 0.0368567F, 0.08351597F }, { 0.034657877F, 0.084452145F }, { 0.032435298F, 0.08533044F }, { 0.030190494F, 0.08615026F }, { 0.027924998F, 0.08691104F }, { 0.025640363F, 0.08761224F }, { 0.023338156F, 0.08825341F }, { 0.021019952F, 0.088834085F }, { 0.018687345F, 0.08935388F }, { 0.016341928F, 0.08981244F }, { 0.0139853135F, 0.09020945F }, { 0.011619112F, 0.090544626F }, { 0.00924495F, 0.09081775F }, { 0.0068644495F, 0.09102864F }, { 0.0044792453F, 0.091177136F }, { 0.0020909712F, 0.091263145F } };
}