package com.integration_client.integration_study_client.application

import java.io.Serializable

data class Mock(
    val value1 : String = "defualt",
    val value2 : String = "default"
) : Serializable