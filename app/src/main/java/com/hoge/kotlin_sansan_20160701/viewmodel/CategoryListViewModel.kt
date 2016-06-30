package com.hoge.kotlin_sansan_20160701.viewmodel

/**
 * Created by okamoto_kazuya on 16/07/01.
 */

class CategoryListViewModel {

    var listItems: List<ListItem> = listOf(
            ListItem.CaptionItem("AV・情報家電"),
            ListItem.SubCaptionItem("映像関連"),
            ListItem.CategoyItem("液晶テレビ"),
            ListItem.CategoyItem("プラズマテレビ"),
            ListItem.CategoyItem("液晶保護フィルム"),
            ListItem.CategoyItem("テレビリモコン"),
            ListItem.CategoyItem("テレビオプション")
    )

    sealed abstract  class ListItem {
        abstract fun getType(): Type

        enum class Type(val id: Int) {
            Caption(10),
            SubCaption(20),
            Category(30),
            ;

            companion object {
                fun from(id: Int): Type {
                    return values().first { it.id == id }
                }
            }

        }

        class CaptionItem(val title: String): ListItem() {
            override fun getType(): Type {
                return Type.Caption
            }
        }

        class SubCaptionItem(val title: String): ListItem() {
            override fun getType(): Type {
                return Type.SubCaption
            }
        }

        class CategoyItem(val title: String): ListItem() {
            override fun getType(): Type {
                return Type.Category
            }
        }

    }

}