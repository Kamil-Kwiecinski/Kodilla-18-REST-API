package com.crud.tasks.trello.client;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;
    private final List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
    private final static List<TrelloBoard> trelloBoardList = new ArrayList<>();
    private final static List<TrelloListDto> trelloListDtoList = new ArrayList<>();
    private final static List<TrelloList> trelloLists = new ArrayList<>();

    @Test
    void shouldMapBoardDtoToBoards() {
        //Given & When
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("name1", "1", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("name2", "2", new ArrayList<>());
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("name3", "3", new ArrayList<>());
        trelloBoardDtoList.addAll(Arrays.asList(trelloBoardDto1, trelloBoardDto2, trelloBoardDto3));

        //Then
        assertNotNull(trelloMapper.mapToBoards(trelloBoardDtoList).get(0));
        assertEquals(3, trelloMapper.mapToBoards(trelloBoardDtoList).size());
    }

    @Test
    void shouldMapBoardToBoardDto() {
        //Given & When
        TrelloBoard trelloBoard1 = new TrelloBoard("name1", "1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("name2", "2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("name3", "3", new ArrayList<>());
        trelloBoardList.addAll(Arrays.asList(trelloBoard1, trelloBoard2, trelloBoard3));

        //Then
        assertNotNull(trelloMapper.mapToBoardsDto(trelloBoardList).get(0));
        assertEquals(3, trelloMapper.mapToBoardsDto(trelloBoardList).size());
    }

    @Test
    void shouldMapCardDtoToCart() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "desc", "top","1");
        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertNotNull(mappedCard);

    }

    @Test
    void shouldMapCardToCartDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name", "desc", "top","1");
        //When
        TrelloCardDto mappedCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertNotNull(mappedCardDto);
    }

    @Test
    void shouldMapListDtoToLists() {
        //Given & When
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "name", false);
        trelloListDtoList.addAll(Arrays.asList(trelloListDto1, trelloListDto2, trelloListDto3));

        //Then
        assertNotNull(trelloMapper.mapToList(trelloListDtoList).get(0));
        assertEquals(3, trelloMapper.mapToList(trelloListDtoList).size());
    }

    @Test
    void shouldMapListsToListDto() {
        //Given & When
        TrelloList trelloList1 = new TrelloList("1", "name", false);
        TrelloList trelloList2 = new TrelloList("2", "name", false);
        TrelloList trelloList3 = new TrelloList("3", "name", false);
        trelloLists.addAll(Arrays.asList(trelloList1, trelloList2, trelloList3));

        //Then
        assertNotNull(trelloMapper.mapToListDto(trelloLists).get(0));
        assertEquals(3, trelloMapper.mapToListDto(trelloLists).size());
    }
}
