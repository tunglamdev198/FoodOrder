package com.lamnt.foodorder

import com.lamnt.foodorder.model.dto.ResponseDTO
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Demo : ResponseDTO<Any?>() {
    private val name: String? = null
}