package iteso.mx.tarea05.activities

import android.app.Application
import com.parse.Parse
import iteso.mx.tarea05.R

private const val APPLICATION_ID = "DR1usOuFtekj567zNlKFeW5dB0qy13CzV1SzM9DU"
private const val CLIENT_KEY = "Mq3fywG9WXVXyN9kIBfh4kQxPWXPCl6lWIjnzLaJ"
private const val SERVER_URL = "https://parseapi.back4app.com/"

class ParseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Configure parse using parse server url, app id and client Key
        // Look at https://docs.parseplatform.org for more details
        configureParse {
            applicationId(APPLICATION_ID)
            clientKey(CLIENT_KEY)
            server(SERVER_URL)
        }
    }

    /** Initialize Parse using the provided server configurations
     * @param builder a lambda function with a [Parse.Configuration.Builder] as its context or Receiver
     */
    private inline fun configureParse(builder: Parse.Configuration.Builder.() -> Unit) {

        return Parse.initialize(Parse.Configuration.Builder(this).apply(builder).build())
    }
}