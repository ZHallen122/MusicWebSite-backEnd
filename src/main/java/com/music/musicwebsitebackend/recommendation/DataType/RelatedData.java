package com.music.musicwebsitebackend.recommendation.DataType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatedData {

    private Integer userId;

    private Integer productId;

    private Integer index;
}
