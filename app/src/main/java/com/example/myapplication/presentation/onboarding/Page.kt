package com.example.myapplication.presentation.onboarding

import android.media.audiofx.AudioEffect.Descriptor
import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class Page(
    val title:String,
    val description: String,
    @DrawableRes val img: Int,
)
val pages = listOf(
    Page(
        title = "Создание удобного личного профиля",
        description = "Приложения, помогающие пользователям создать впечатляющее персональное резюме для работодателей",
        img = R.drawable.joblogi2
    ),
    Page(
        title = "Быстрый поиск работы",
        description = "Приложение предоставляет и рекомендует разнообразные вакансии, соответствующие потребностям соискателей",
        img = R.drawable.logo2
    ),
    Page(
        title = "Высокая надежность",
        description = "Приложение гарантирует пользователям наилучший опыт с точки зрения удобства, надежности и высокого уровня безопасности",
        img = R.drawable.logo3
    ),

)