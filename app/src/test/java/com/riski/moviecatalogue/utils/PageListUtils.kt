package com.riski.moviecatalogue.utils

import androidx.paging.PagedList
import org.mockito.Mockito.*

object PageListUtils {
    fun <T> mockPagedList(list : List<T>) : PagedList<T> {
        val pagedList = mock(PagedList::class.java) as PagedList<T>
        `when`(pagedList[anyInt()]).then { inovaction ->
            val index = inovaction.arguments.first() as Int
            list[index]
        }
        `when`(pagedList.size).thenReturn(list.size)

        return pagedList
    }
}