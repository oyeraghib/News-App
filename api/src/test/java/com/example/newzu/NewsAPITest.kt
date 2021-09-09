package com.example.newzu

import com.example.api.NewsAPIClient
import org.junit.Test
import org.junit.Assert.assertNotNull

class NewsAPITest {

    val resp = NewsAPIClient.api

@Test
fun `get Top Headlines INDIA` () {

    val req = resp.getTopHeadlinesIndia().execute()
    assertNotNull(req.body()?.articles)

}

    @Test
    fun `get Top Headlines USA`() {

        val req = resp.getTopHeadlinesUS().execute()
        assertNotNull(req.body()?.articles)

    }

}
