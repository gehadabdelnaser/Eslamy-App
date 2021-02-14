package com.gehad.eslamy.data

import com.google.gson.annotations.SerializedName

data class RadiosItem(

	@field:SerializedName("URL")
	val uRL: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
)