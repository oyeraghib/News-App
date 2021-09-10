package com.example.newzu

import com.example.api.NewsAPIClient
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertNotNull

class NewsAPITest {

    val resp = NewsAPIClient.api

@Test
fun `get Top Headlines INDIA` () {

        runBlocking {
            val req = resp.getTopHeadlinesIndia()
            assertNotNull(req.body()?.articles)
        }


}

    @Test
    fun `get Top Headlines USA`() {

        runBlocking {
            val req = resp.getTopHeadlinesUS()
            assertNotNull(req.body()?.articles)
        }



    }

}
