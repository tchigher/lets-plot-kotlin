/*
 * Copyright (c) 2019. JetBrains s.r.o.
 * Use of this source code is governed by the MIT license that can be found in the LICENSE file.
 */

package frontendContextDemo.scripts

import jetbrains.letsPlot.geom.geom_point
import jetbrains.letsPlot.label.ggtitle
import jetbrains.letsPlot.lets_plot
import jetbrains.letsPlot.scale.scale_size_area
import frontendContextDemo.ScriptInJfxContext
import kotlin.math.PI
import kotlin.math.sin

object Title {
    @JvmStatic
    fun main(args: Array<String>) {
        ScriptInJfxContext.eval("ggtitle()") {
            val dat = mapOf<String, Any>(
                "x" to (0..100).map { it * 2 * PI / 100 },
                "y" to (0..100).map { sin(it * 2 * PI / 100) }
            )

            val p = lets_plot(dat) +
                    geom_point { x = "x"; y = "y" } +
                    ggtitle("Sine function") +
                    scale_size_area(maxSize = 70, guide = "none")

            p.show()
        }
    }
}