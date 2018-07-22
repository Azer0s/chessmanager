package com.simulevski.chessmanager.domain;

import lombok.var;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TitlesTest {

    private final String title = "A";
    private final String description = "ABC; 123; as easy as doremi";

    @Test
    public void EnsureTitlesWork(){
        var title = com.simulevski.chessmanager.domain.Titles.builder()
                .id(this.title)
                .description(this.description)
                .build();

        assertEquals(title.getId(),this.title);
        assertEquals(title.getDescription(),this.description);

        String id = "B";
        String desc = "BCD";

        title.setId(id);
        title.setDescription(desc);

        assertEquals(title.getId(),id);
        assertEquals(title.getDescription(),desc);
    }
}
