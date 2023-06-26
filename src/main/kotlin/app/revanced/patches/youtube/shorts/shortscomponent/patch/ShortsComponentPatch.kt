package app.revanced.patches.youtube.shorts.shortscomponent.patch

import app.revanced.patcher.annotation.Description
import app.revanced.patcher.annotation.Name
import app.revanced.patcher.annotation.Version
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.PatchResult
import app.revanced.patcher.patch.PatchResultSuccess
import app.revanced.patcher.patch.annotations.DependsOn
import app.revanced.patcher.patch.annotations.Patch
import app.revanced.patches.youtube.shorts.shortsnavigationbar.patch.ShortsNavigationBarPatch
import app.revanced.patches.youtube.utils.annotations.YouTubeCompatibility
import app.revanced.patches.youtube.utils.litho.patch.LithoFilterPatch
import app.revanced.patches.youtube.utils.resourceid.patch.SharedResourceIdPatch
import app.revanced.patches.youtube.utils.settings.resource.patch.SettingsPatch
import app.revanced.util.bytecode.BytecodeHelper.updatePatchStatus
import app.revanced.util.integrations.Constants.PATCHES_PATH

@Patch
@Name("hide-shorts-component")
@Description("Hides other Shorts components.")
@DependsOn(
    [
        LithoFilterPatch::class,
        SettingsPatch::class,
        SharedResourceIdPatch::class,
        ShortsCommentButtonPatch::class,
        ShortsDislikeButtonPatch::class,
        ShortsInfoPanelPatch::class,
        ShortsLikeButtonPatch::class,
        ShortsNavigationBarPatch::class,
        ShortsPaidContentBannerPatch::class,
        ShortsRemixButtonPatch::class,
        ShortsShareButtonPatch::class,
        ShortsSubscriptionsButtonPatch::class
    ]
)
@YouTubeCompatibility
@Version("0.0.1")
class ShortsComponentPatch : BytecodePatch() {
    override fun execute(context: BytecodeContext): PatchResult {

        LithoFilterPatch.addFilter("$PATCHES_PATH/ads/ShortsFilter;")

        context.updatePatchStatus("ShortsComponent")

        /**
         * Add settings
         */
        SettingsPatch.addPreference(
            arrayOf(
                "PREFERENCE: SHORTS_SETTINGS",
                "SETTINGS: HIDE_SHORTS_SHELF",
                "SETTINGS: SHORTS_PLAYER_PARENT",
                "SETTINGS: HIDE_SHORTS_COMPONENTS"
            )
        )

        SettingsPatch.updatePatchStatus("hide-shorts-component")

        return PatchResultSuccess()
    }
}