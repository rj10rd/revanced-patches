package app.revanced.patches.shared.annotation

import app.revanced.patcher.annotation.Compatibility
import app.revanced.patcher.annotation.Package

@Compatibility(
    [Package(
        "com.google.android.youtube", arrayOf(
            "18.06.41",
            "18.07.35",
            "18.08.39",
            "18.09.39",
            "18.10.37",
            "18.11.36",
            "18.12.35",
            "18.13.38",
            "18.14.40"
        )
    )]
)
@Target(AnnotationTarget.CLASS)
internal annotation class YouTubeCompatibility

