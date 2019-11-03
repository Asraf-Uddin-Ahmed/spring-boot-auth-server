package com.asraf.auth.dtos.mapper;

import com.asraf.auth.dtos.request.BaseRequestDto;
import com.asraf.auth.dtos.response.entities.BaseEntityResponseDto;
import com.asraf.auth.entities.BaseEntity;

public interface RequestResponseDtoMapper<TEntity extends BaseEntity, TResponseDto extends BaseEntityResponseDto, TRequestDto extends BaseRequestDto>
		extends ResponseDtoMapper<TEntity, TResponseDto> {

	TEntity getEntity(TRequestDto requestDto);

	void loadEntity(TRequestDto requestDto, TEntity entity);

}
