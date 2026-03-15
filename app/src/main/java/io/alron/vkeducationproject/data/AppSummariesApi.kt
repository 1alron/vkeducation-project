package io.alron.vkeducationproject.data

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class AppSummariesApi {
    suspend fun get(): List<AppSummaryDto> {
        delay(1.seconds) // типа к бекенду обращаемся :)
        return listOf(
            AppSummaryDto(
                id = "12345",
                name = "Яндекс Браузер с Алисой AI",
                description = "Быстрый и безопасный браузер",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/bZNt9jiZUOVXXOG0JdJQleTYIB2cFeE3MaWk7o897jE/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/10/25/1e/apk/579007/content/ICON/939321c0-03f7-484d-9043-c0fb12736ef1.png@webp"
            ),
            AppSummaryDto(
                id = "12346",
                name = "MAX: общение, звонки сервисы",
                description = "Мессенджер для комфортного общения",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/JNQXxouJcssXg2hd8FaJX6Bj9OXC2l0Xd2KBtHWxo6c/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/1/24/6f/apk/2063618637/content/ICON/0564e0a3-a2be-414e-8fec-55257fedea8e.png@webp"
            ),
            AppSummaryDto(
                id = "12347",
                name = "Mail: Почта, Облако, Календарь",
                description = "Быстрый и удобный почтовый клиент",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/G4zJRwh_JpnM5CLGpQU8bKCUWaCYJCXNWuK_vcqFmOY/preset:web_app_icon_160/plain/https://static.rustore.ru/2025/12/18/49/apk/332223/content/ICON/79bd5fd2-13fb-4218-874f-7d3d651d344f.png@webp"
            ),
            AppSummaryDto(
                id = "12348",
                name = "Мамба - знакомства и общение",
                description = "Популярное приложение и сайт знакомств",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/CEMgcB_iSy0UPjf0kSuMxoSZ1oH7GlbW6Bo9pKnqls8/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/252095/content/ICON/cc14fa6c-a132-47a5-a381-e9380940dbe4.png@webp"
            ),
            AppSummaryDto(
                id = "12349",
                name = "Дурак Онлайн",
                description = "Карточная сетевая игра",
                category = "Game",
                iconUrl = "https://static.rustore.ru/imgproxy/EHdW4wvAZ6bobcaLhNtTc_ucmGRjfnTQ72OHfJrHU00/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/1707711679/content/ICON/218cbf72-4536-4d9b-80fa-84e17e2a3542.png@webp"
            ),
            AppSummaryDto(
                id = "12340",
                name = "Блок бласт - игры без интернета",
                description = "Бесконечная головоломка с блоками",
                category = "Game",
                iconUrl = "https://static.rustore.ru/imgproxy/Oh9fYTpTgAfjrEd3ViF_xBOPYG0a7jnhcLcxDYu1taE/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2063640458/content/ICON/e82371db-9129-440f-97ac-6ec82af5af6f.png@webp"
            ),
            AppSummaryDto(
                id = "12351",
                name = "RUTUBE: видео, шоу, трансляции",
                description = "Контент на любой вкус онлайн 24/7",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/6EbHeSfv610Bn7lLg7-um439wIwlxK-4wtUUGTn86dI/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/246207/content/ICON/a56aebe3-565a-4bf6-942d-1f14994b9a6e.png@webp"
            ),
            AppSummaryDto(
                id = "12352",
                name = "Пятёрочка: доставка продуктов",
                description = "Доставка продуктов и заказ готовой еды на дом",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/qJ-_fdHPDF0zi-_1SIzswH9AHuufobugb4AqmEhIGrQ/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/11/78/apk/733089215/content/ICON/714f52ba-a024-42df-bb8d-f2dbf6c7e939.png@webp"
            ),
            AppSummaryDto(
                id = "12353",
                name = "Kaspersky: Антивирус и Защита",
                description = "Бесплатный антивирус и другие защитные технологии",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/6ayFckoJGGH9jsfIXGC8EUN_LCsS0LrEfEGplWE2T0Y/preset:web_app_icon_160/plain/https://static.rustore.ru/apk/2255039/content/ICON/5a4abaaf-dfcb-48ab-bf21-507ecc0563e7.png@webp"
            ),
            AppSummaryDto(
                id = "12354",
                name = "WILDBERRIES",
                description = "Масштабная цифровая платформа, где можно найти все",
                category = "App",
                iconUrl = "https://static.rustore.ru/imgproxy/Sr1aALKlIlaiF4zgJvnb6V2WcJmpsjrLwuX3H8gRqZA/preset:web_app_icon_160/plain/https://static.rustore.ru/2026/2/11/07/apk/234943/content/ICON/b7e12348-1345-45fb-9755-2cf7a866f16f.png@webp"
            )
        )
    }
}