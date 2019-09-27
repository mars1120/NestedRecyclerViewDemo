package com.demo.nestedrecyclerview

data class ItemParentModel (
    val title : String = "",
    val children : List<ChildModel>
)