package com.example.kotlinnote.data.entity

import io.realm.RealmObject
open class  NoteRealm(var myNote: String ="") : RealmObject()