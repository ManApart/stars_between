package ui.shipScene

import game.Game
import tile.SystemType

class ShipViewOptions{
    var mode: ShipViewMode = ShipViewMode.BUILD
    var selectedTileType = SystemType.SPACE
    var selectedTile = Game.floorPlan.getTile(0,0)
}