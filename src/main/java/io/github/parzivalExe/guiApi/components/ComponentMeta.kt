package io.github.parzivalExe.guiApi.components

import io.github.parzivalExe.guiApi.xml.IXmlTag
import io.github.parzivalExe.guiApi.xml.XMLAttribute
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class ComponentMeta(@XMLAttribute(necessary = true ) var name: String, @XMLAttribute(necessary = true) private var look: ItemStack) : IXmlTag {

    @XMLAttribute
    var description = arrayListOf<String>()
    var savedObjects = hashMapOf<String, Any>()


    //region simple methods

    fun addDescriptionLine(descriptionLine: String) {
        description.add(descriptionLine)
    }

    fun getDescriptionAsString(): String {
        var string = ""
        description.forEach { line -> string += line + "\n" }
        string.removeSuffix("\n")
        return string
    }

    //endregion


    fun setLook(look: ItemStack) {
        this.look = look
    }

    fun buildItem(): ItemStack {
        val itemMeta = look.itemMeta
        itemMeta.apply {
            displayName = name
            lore = description
        }
        look.itemMeta = itemMeta
        return look
    }

}