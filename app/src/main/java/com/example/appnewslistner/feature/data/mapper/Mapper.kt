package com.example.appnewslistner.feature.data.mapper

import com.example.appnewslistner.feature.data.domain.ArticleModel
import com.example.appnewslistner.feature.data.model.ArticleRemoteModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
    autor=autor?:""
    ,title=title?:""
    ,description=description?:""
    ,url=url?:""

)