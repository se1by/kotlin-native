package org.jetbrains.kotlin.backend.konan

import org.jetbrains.kotlin.backend.konan.util.prefixBaseNameIfNot
import org.jetbrains.kotlin.backend.konan.util.removeSuffixIfPresent
import org.jetbrains.kotlin.backend.konan.util.suffixIfNot
import org.jetbrains.kotlin.konan.file.File
import org.jetbrains.kotlin.konan.target.CompilerOutputKind
import org.jetbrains.kotlin.konan.target.KonanTarget
import org.jetbrains.kotlin.konan.util.visibleName


/**
 * Creates and stores terminal compiler outputs
 */
class OutputFiles(outputPath: String?, target: KonanTarget, produce: CompilerOutputKind) {

    private val prefix = produce.prefix(target)
    private val suffix = produce.suffix(target)

    val outputName = outputPath?.removeSuffixIfPresent(suffix) ?: produce.visibleName

    /**
     * Header file for dynamic library
     */
    val cAdapterHeader      by lazy { File("${outputName}_api.h") }

    /**
     * Main compiler's output file
     */
    val mainFile = outputName
            .prefixBaseNameIfNot(prefix)
            .suffixIfNot(suffix)
}