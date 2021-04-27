package org.rak.starsBetween.views.planetView

import org.rak.starsBetween.planets.Planet
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.awt.image.BufferedImage.TYPE_INT_RGB

class PlanetPainter {
    fun paint(planet: Planet, type: PlanetViewType): BufferedImage {
        val img = BufferedImage(100, 100, TYPE_INT_RGB)
        val g = img.createGraphics()

        when (type){
            PlanetViewType.ALTITUDE -> paintAltitude(planet, g)
            else -> paintBiomes(planet, g)
        }

        g.dispose()
        return img
    }

    private fun paintBiomes(planet: Planet, g: Graphics2D) {
        for (x in planet.regions.indices) {
            for (y in planet.regions.indices) {
                g.color = planet.regions[x][y].biome.color
                g.fillRect(x, y, 1, 1)
            }
        }
    }

    private fun paintAltitude(planet: Planet, g: Graphics2D) {
        for (x in planet.regions.indices) {
            for (y in planet.regions.indices) {
                val altitude = planet.regions[x][y].altitude
                g.color = altitudeSpectrum.getColor(altitude)
                g.fillRect(x, y, 1, 1)
            }
        }
    }
}