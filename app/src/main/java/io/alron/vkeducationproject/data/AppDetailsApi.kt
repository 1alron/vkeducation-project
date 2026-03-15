package io.alron.vkeducationproject.data

import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

// Представим, что тут вызывается бекенд :)
class AppDetailsApi {
    suspend fun get(id: String): AppDetailsDto {
        delay(2.seconds)
        return AppDetailsDto(
            id = "346235",
            name = "Яндекс Браузер с Алисой AI",
            developer = "ООО \"ЯНДЕКС\"",
            category = "App",
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
        )
    }
}