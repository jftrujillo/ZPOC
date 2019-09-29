package com.example.zpoc.data.mapper

interface  BaseMapper<T,P> {

    fun tranformTo(inObject: T): P

    fun transformFrom(inObject: P): T
}