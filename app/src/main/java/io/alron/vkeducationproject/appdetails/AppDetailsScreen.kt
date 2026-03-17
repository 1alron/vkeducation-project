package io.alron.vkeducationproject.appdetails

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.alron.vkeducationproject.Category
import io.alron.vkeducationproject.R
import io.alron.vkeducationproject.ui.theme.VKEducationProjectTheme

@Composable
fun AppDetailsScreen(
    appId: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val appList = remember { getAppList() }

    val context = LocalContext.current
    val underDevelopmentText = stringResource(R.string.under_developement)

    var descriptionCollapsed by remember { mutableStateOf(false) }

    Column(modifier) {
        Toolbar(
            onBackClick = onBackClick,
            onShareClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
        )
        Spacer(Modifier.height(8.dp))
        AppDetailsHeader(
            app = appList[appId],
            modifier = Modifier.padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(16.dp))
        InstallButton(
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(Modifier.height(12.dp))
        ScreenshotsList(
            screenshotUrlList = appList[appId].screenshotUrlList,
            contentPadding = PaddingValues(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        AppDescription(
            description = appList[appId].description,
            collapsed = descriptionCollapsed,
            onReadMoreClick = {
                descriptionCollapsed = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        Spacer(Modifier.height(12.dp))
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.outlineVariant,
        )
        Spacer(Modifier.height(12.dp))
        Developer(
            name = appList[appId].developer,
            onClick = {
                Toast.makeText(context, underDevelopmentText, Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
        )
    }
}

// В будущем заменим этот метод на вызов API.
private fun getAppList(): List<App> = listOf(
    App(
        name = "Яндекс Браузер с Алисой AI",
        developer = "ООО \"ЯНДЕКС\"",
        category = Category.APP,
        ageRating = 0,
        size = 143.3f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/PFLM-GlJd_frNCL5vR_OJZZQhzdL3fvgdvIdpJrVq4A/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/6a/apk/579007/content/SCREENSHOT/b14e7901-1fcb-4045-94af-3464c359f224.jpg@webp",
            "https://static.rustore.ru/imgproxy/wAYoW7mF9FERBTTrYt6bEodhDIRSa8WZIcgYfGk3oxU/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/b3/apk/579007/content/SCREENSHOT/816a1cc0-31aa-431f-a560-51aad66f7342.jpg@webp",
            "https://static.rustore.ru/imgproxy/Fs5c_h_5CDN9x08e-7hwqtRjLp-SHCktgtEr54qUfEE/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/81/apk/579007/content/SCREENSHOT/1d9d8a7f-9d6d-4b53-9107-c379bbd1ce48.jpg@webp",
            "https://static.rustore.ru/imgproxy/Au3P2Niy_5KX1We1FiE018ua2_ESFPF4ojmIq8hLrew/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/25/bc/apk/579007/content/SCREENSHOT/eb4422a7-36cf-4d11-a25a-456026f39cc7.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/bZNt9jiZUOVXXOG0JdJQleTYIB2cFeE3MaWk7o897jE/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp",
        description = "Яндекс Браузер — быстрый и безопасный браузер с Алисой AI и выгодными покупками."
    ),
    App(
        name = "MAX: общение, звонки сервисы",
        developer = "Коммуникационная Платформа",
        category = Category.APP,
        ageRating = 6,
        size = 31.0f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/JS3O1NWclSDq5-wEtauTz1ywmAuF61gUkGOliqp2c7U/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/24/f1/apk/2063618637/content/SCREENSHOT/d13674cb-7c7d-4140-be93-b77ca7d9fa55.jpg@webp",
            "https://static.rustore.ru/imgproxy/6bH8WRU_Zec-0vJw-4ornY9yvPLl4cc90uUzQGErqCs/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/24/ef/apk/2063618637/content/SCREENSHOT/87876d76-ff96-4f8f-b93e-2dc8d2b9c9d1.jpg@webp",
            "https://static.rustore.ru/imgproxy/7BZWkhhlfofNKOIpmaiAWjSEfKnVcAfXT6h8djLztiw/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/24/3b/apk/2063618637/content/SCREENSHOT/94823098-b9f8-446c-b0c4-4d0264378187.jpg@webp",
            "https://static.rustore.ru/imgproxy/6CwKOdxWcrQUeuQbf6-rvHoABwsmjNSq44xmic65BtY/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/1/24/81/apk/2063618637/content/SCREENSHOT/3b3f98f2-250f-4910-baeb-ec86e82c5b44.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/JNQXxouJcssXg2hd8FaJX6Bj9OXC2l0Xd2KBtHWxo6c/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/24/6f/apk/2063618637/content/ICON/0564e0a3-a2be-414e-8fec-55257fedea8e.png@webp",
        description = "MAX — новая цифровая платформа, которая объединяет в себе сервисы для решения повседневных задач и мессенджер для комфортного общения. Это быстрое и легкое приложение, где можно переписываться, звонить, отправлять стикеры, голосовые сообщения и пользоваться разными полезными сервисами."
    ),
    App(
        name = "Mail: Почта, Облако, Календарь",
        developer = "VK",
        category = Category.APP,
        ageRating = 0,
        size = 185.1f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/-y8kd-4B6MQ-1OKbAbnoAIMZAzvoMMG9dSiHMpFaTBc/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/dfd33017-e90d-4990-aa8c-6f159d546788.jpg@webp",
            "https://static.rustore.ru/imgproxy/dZCvNtRKKFpzOmGlTxLszUPmwi661IhXynYZGsJQvLw/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/60ec4cbc-dcf6-4e69-aa6f-cc2da7de1af6.jpg@webp",
            "https://static.rustore.ru/imgproxy/g5whSI1uNqaL2TUO7TFfM8M63vXpWXNCm2vlX4Ahvc4/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/c2dde8bc-c4ab-482a-80a5-2789149f598d.jpg@webp",
            "https://static.rustore.ru/imgproxy/TjeurtC7BczOVJt74XhjGYuQnG1l4rx6zpDqyMb00GY/preset:web_scr_lnd_335/plain/https://static.rustore.ru/apk/393868735/content/SCREENSHOT/08318f76-7a9c-43aa-b4a7-1aa878d00861.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/G4zJRwh_JpnM5CLGpQU8bKCUWaCYJCXNWuK_vcqFmOY/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/12/18/49/apk/332223/content/ICON/79bd5fd2-13fb-4218-874f-7d3d651d344f.png@webp",
        description = "Добавьте все свои аккаунты и читайте электронную почту с ящиков на Mail, Яндекс, Microsoft Outlook почта, Gmail от Google, Rambler, Yahoo и других сервисов. Отправляйте письма, записывайте дела в рабочий или личный календарь, загружайте фото и документы на диск в Облако Mail. Звонки, новости и погода — всё в одном приложении!"
    ),
    App(
        name = "Мамба - знакомства и общение",
        developer = "АО \"Мамба\"",
        category = Category.APP,
        ageRating = 18,
        size = 49.1f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/zcDqigzbohYyEEuxnZgDUH_CxCvFL6CshBIeipO_6VY/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/252095/content/SCREENSHOT/ec8f664b-9314-44e1-b845-f50437177332.png@webp",
            "https://static.rustore.ru/imgproxy/-zuDf9W3q3eAz48b1d4gmVB6lgc2Ctyuh8LdnyCkQJs/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/252095/content/SCREENSHOT/0649dc26-6e1b-4329-8442-c46389a870b6.png@webp",
            "https://static.rustore.ru/imgproxy/rGZivpA1QygAyZarpLzau0KVT3GqiA0yp_hqiRzlQL0/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/252095/content/SCREENSHOT/f12963e2-378a-49ee-892b-b1eddd3b0c53.png@webp",
            "https://static.rustore.ru/imgproxy/MxO1xc7eQLcKGrvMI_8Ei4cqy_1fyk4KGSo0yK71gFk/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/252095/content/SCREENSHOT/9fccd876-b3c4-4d4a-bfba-ee7a8e321b30.png@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/CEMgcB_iSy0UPjf0kSuMxoSZ1oH7GlbW6Bo9pKnqls8/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/252095/content/ICON/cc14fa6c-a132-47a5-a381-e9380940dbe4.png@webp",
        description = "Мамба® – популярное приложение и сайт знакомств в России. Пообщаемся? ❤\n" +
                "Скачайте приложение прямо сейчас и начните новые знакомства, а может и отношения! Свайп влево, свайп вправо, один лайк, одно единственное «привет», и ваша жизнь уже изменилась навсегда!"
    ),
    App(
        name = "Дурак Онлайн",
        developer = "ООО \"Р-Софт\"",
        category = Category.GAME,
        ageRating = 12,
        size = 59.3f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/NVOAzTHvzP8aoZupikctqTgoghQFfWGfcO1HpuS7buA/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/1707711679/content/SCREENSHOT/bf2f7fe8-fff5-4d04-90a9-c4ced79fdfc3.jpg@webp",
            "https://static.rustore.ru/imgproxy/mdhGt5NFdpvJQZI_aC5mNN_eY4-aDqV0Yiddq49raT8/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/1707711679/content/SCREENSHOT/15272794-9d24-4526-a72f-9daf577cf2a3.jpg@webp",
            "https://static.rustore.ru/imgproxy/em4x2ud6qyh1qirfNRPsD3-tjSQE8p383U1zvNqLlbk/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/1707711679/content/SCREENSHOT/9ee2bde7-0aea-46b4-a7eb-07bc8be9f0ab.jpg@webp",
            "https://static.rustore.ru/imgproxy/yjlxynl4oYuJ-7LbWci9nnLojU0WAeRJWibT67Fdzuo/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/1707711679/content/SCREENSHOT/b7182e52-6003-43c3-bd06-7b3faf920544.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/EHdW4wvAZ6bobcaLhNtTc_ucmGRjfnTQ72OHfJrHU00/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/1707711679/content/ICON/218cbf72-4536-4d9b-80fa-84e17e2a3542.png@webp",
        description = "Дурак Онлайн - карточная сетевая игра, в которую играют больше 10 миллионов пользователей!"
    ),
    App(
        name = "Блок бласт - игры без интернета",
        developer = "Aimi(Hong Kong) International Trade Co., Limited",
        category = Category.GAME,
        ageRating = 0,
        size = 64.6f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/v5hrO98_msAqsTLfpJHFk_4LV7czghwdLapEJ0nuAOc/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/2063640458/content/SCREENSHOT/a2f9c863-1fd8-4f69-b65f-ff102b70d4af.png@webp",
            "https://static.rustore.ru/imgproxy/O8ZyMsQ7K_6xuxON8VlQ_RbkLvgUo1fTMkwN-3fSlbo/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/2063640458/content/SCREENSHOT/9313608f-018a-4c95-bc63-ba9f72d9e2d1.png@webp",
            "https://static.rustore.ru/imgproxy/ScBYzzZ60lxB4DHUH6kgL1YE58ewsRxWoj-Kr_Dlnyw/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/2063640458/content/SCREENSHOT/c55a2655-b612-45d0-a2db-2e7de4fa2526.png@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/Oh9fYTpTgAfjrEd3ViF_xBOPYG0a7jnhcLcxDYu1taE/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2063640458/content/ICON/e82371db-9129-440f-97ac-6ec82af5af6f.png@webp",
        description = "Блок бласт — это бесконечная головоломка с блоками, где каждое движение имеет значение. Размещайте блоки, собирайте комбо и набирайте очки. Сохраняйте концентрацию, думайте наперёд и узнайте, насколько высоко вы можете подняться!"
    ),
    App(
        name = "RUTUBE: видео, шоу, трансляции",
        developer = "ООО \"РУФОРМ\"",
        category = Category.APP,
        ageRating = 12,
        size = 31.3f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/jVSKEPHr5fjhwAwwlPMziA3PkFX9C98YA3T_08T1-yc/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/246207/content/SCREENSHOT/30aad19a-6bd9-4712-b28b-ec67c1bff903.jpg@webp",
            "https://static.rustore.ru/imgproxy/eQxd9jSBFMArkiH-qkcAYX_a3AyW4Qoc999pW9KT7TA/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/246207/content/SCREENSHOT/899b2b79-19db-43cd-9469-4b58e201da34.jpg@webp",
            "https://static.rustore.ru/imgproxy/VuoTuvXgP4yFytck72H2lEoW6ClgpViTdmx3c1GSmII/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/246207/content/SCREENSHOT/21fd8e12-ca86-47c8-a5e5-ff85356512ff.jpg@webp",
            "https://static.rustore.ru/imgproxy/AIns8f42epm51dysxuXZBWi2GXGVSKqVXgo99nBeIEY/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/246207/content/SCREENSHOT/2079f60e-29b1-40cf-a880-d58acd59a512.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/6EbHeSfv610Bn7lLg7-um439wIwlxK-4wtUUGTn86dI/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/246207/content/ICON/a56aebe3-565a-4bf6-942d-1f14994b9a6e.png@webp",
        description = "Видеохостинг RUTUBE — стремительно растущая платформа для любителей и создателей контента. Смотрите видео, трансляции, сериалы, фильмы от крупнейших онлайн-кинотеатров — «Иви», PREMIER, START — и ТВ онлайн. Делитесь собственными видео с миллионами зрителей, развивайте свой канал и зарабатывайте на своём творчестве!"
    ),
    App(
        name = "Пятёрочка: доставка продуктов",
        developer = "ООО «ИТ ИКС 5 Технологии»",
        category = Category.APP,
        ageRating = 0,
        size = 51.3f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/ryNsjcfWf1rjF4MRF_hMY0inSd8hSB3_9N-XFG7RrkM/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/1/35/apk/733089215/content/SCREENSHOT/615c55af-4965-45f6-95f7-0b3428f7c308.jpg@webp",
            "https://static.rustore.ru/imgproxy/zCPZb1s_KUZh8-3njWr4fY6gTl8tTxlsgufAi9z6_EA/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/1/c9/apk/733089215/content/SCREENSHOT/d4adfdfa-7e08-4c91-9978-00bc758e2201.jpg@webp",
            "https://static.rustore.ru/imgproxy/OXq1Pa4LtzDroez8JM91JP1BcySMHvxu1QKYOXw_Cac/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/10/1/0e/apk/733089215/content/SCREENSHOT/a2a5c748-97f5-417e-bd6d-704856e28303.jpg@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/qJ-_fdHPDF0zi-_1SIzswH9AHuufobugb4AqmEhIGrQ/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/11/78/apk/733089215/content/ICON/714f52ba-a024-42df-bb8d-f2dbf6c7e939.png@webp",
        description = "Пятёрочка — доставка продуктов и заказ готовой еды на дом.\n" +
                "\n" +
                "Доставляем в Москве, Санкт-Петербурге, Новосибирске, Казани, Нижнем Новгороде, Челябинске, Самаре, Омске, Ростове-на-Дону, Екатеринбурге, Уфе, Красноярске, Перми, Воронеже, Волгограде — всего в более 700 городах. Постоянно расширяем зоны доставки!"
    ),
    App(
        name = "Kaspersky: Антивирус и Защита",
        developer = "АО \"Лаборатория Касперского\"",
        category = Category.APP,
        ageRating = 0,
        size = 131.6f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/vQBkA0vEZP7I_aDQbld66gJuwAxLwZWmD6e3dvpuk24/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/2255039/content/SCREENSHOT/625a7667-f72e-42a8-afca-282510a87530.png@webp",
            "https://static.rustore.ru/imgproxy/Hw9T1bl1nFLmkG7G5_kpjULMdHdYp-z49PtkMMFAdlM/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/2255039/content/SCREENSHOT/98a0fd3b-829b-4082-a063-236ffd34efa6.png@webp",
            "https://static.rustore.ru/imgproxy/hq9LkcK4JkSBp3lZraTud6zkwQt1FaiXt3z7xZXfWcI/preset:web_scr_prt_162/plain/https://static.rustore.ru/apk/2255039/content/SCREENSHOT/35e725e9-8b80-402a-8b8b-23354db92d7c.png@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/6ayFckoJGGH9jsfIXGC8EUN_LCsS0LrEfEGplWE2T0Y/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2255039/content/ICON/5a4abaaf-dfcb-48ab-bf21-507ecc0563e7.png@webp",
        description = "Бесплатный антивирус и другие защитные технологии для Android\n" +
                "\n" +
                "Kaspersky: Антивирус и защита – это бесплатное антивирусное решение, защищающее от онлайн-угроз смартфоны и планшеты, которые порой даже более уязвимы, чем компьютеры."
    ),
    App(
        name = "WILDBERRIES",
        developer = "ООО \"Вайлдберриз\"",
        category = Category.APP,
        ageRating = 0,
        size = 283.3f,
        screenshotUrlList = listOf(
            "https://static.rustore.ru/imgproxy/3bPD0BUpuTQAbn31LobRz5l_bbQdCGZFBcEwhDep72w/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/11/80/apk/234943/content/SCREENSHOT/0f33e564-e78f-499a-9521-9c53b42a2d2e.png@webp",
            "https://static.rustore.ru/imgproxy/PdsK2s7-WpXIv3kALWI2wJz02mpEQrGrSb6FFO17o2A/preset:web_scr_prt_162/plain/https://static.rustore.ru/2026/2/11/bd/apk/234943/content/SCREENSHOT/8212e7db-dfd8-42b1-8594-89faceb334a3.png@webp",
            "https://static.rustore.ru/imgproxy/KH8bQgoO4hjEhrCIGTBaqhh4fhyHxA0T9glH16oDz2g/preset:web_scr_prt_162/plain/https://static.rustore.ru/2025/12/18/9a/apk/234943/content/SCREENSHOT/a7bda1cc-0ebd-4cfa-8771-3b38dc95501d.png@webp",
        ),
        iconUrl = "https://static.rustore.ru/imgproxy/Sr1aALKlIlaiF4zgJvnb6V2WcJmpsjrLwuX3H8gRqZA/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/11/07/apk/234943/content/ICON/b7e12348-1345-45fb-9755-2cf7a866f16f.png@webp",
        description = "Wildberries — это масштабная цифровая платформа, где можно найти почти всё: от пушистых тапочек-единорогов до автомобилей и недвижимости. Встречи с вами ждут миллионы самых разных товаров, а ещё приятные скидки и акции."
    )
)

@Preview(showBackground = true)
@Composable
private fun Preview() {
    VKEducationProjectTheme {
        AppDetailsScreen(
            appId = 0,
            onBackClick = { },
            modifier = Modifier.fillMaxSize(),
        )
    }
}