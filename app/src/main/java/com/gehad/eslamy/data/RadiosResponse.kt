package com.gehad.eslamy.data

import com.google.gson.annotations.SerializedName

data class RadiosResponse(

	@field:SerializedName("Radios")
	val radios: List<RadiosItem?>? = null
)