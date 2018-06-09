package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void testMapperToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(new TrelloBoardDto("Id_1","Name_1", new ArrayList<>()));
        trelloBoardDtoList.add(new TrelloBoardDto("Id_2", "Name_2", new ArrayList<>()));

        //When
        trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        Assert.assertEquals("Name_1", trelloMapper.mapToBoards(trelloBoardDtoList).get(0).getName());
        Assert.assertEquals("Id_2", trelloMapper.mapToBoards(trelloBoardDtoList).get(1).getId());
        Assert.assertEquals(2, trelloMapper.mapToBoards(trelloBoardDtoList).size());
    }

    @Test
    public void testMapperToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoardsList = new ArrayList<>();
        trelloBoardsList.add(new TrelloBoard("Id_1", "Name_1", new ArrayList<>()));
        trelloBoardsList.add(new TrelloBoard("Id_2", "Name_2", new ArrayList<>()));

        //When
        trelloMapper.mapToBoardsDto(trelloBoardsList);

        //Then
        Assert.assertEquals("Name_1", trelloMapper.mapToBoardsDto(trelloBoardsList).get(0).getName());
        Assert.assertEquals("Id_2", trelloMapper.mapToBoardsDto(trelloBoardsList).get(1).getId());
        Assert.assertEquals(2, trelloMapper.mapToBoardsDto(trelloBoardsList).size());
    }

    @Test
    public void testMapperToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("Id_1", "Name_1", false));
        trelloListDto.add(new TrelloListDto("Id_2", "Name_2", true));

        //When
        trelloMapper.mapToList(trelloListDto);

        //Then
        Assert.assertEquals("Name_1", trelloMapper.mapToList(trelloListDto).get(0).getName());
        Assert.assertEquals(true, trelloMapper.mapToList(trelloListDto).get(1).isClosed());
        Assert.assertEquals(2, trelloMapper.mapToList(trelloListDto).size());
    }

    @Test
    public void testMapperToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("Id_1", "Name_1", false));
        trelloLists.add(new TrelloList("Id_2", "Name_2", true));

        //When
        trelloMapper.mapToListDto(trelloLists);

        //Then
        Assert.assertEquals("Name_1", trelloMapper.mapToListDto(trelloLists).get(0).getName());
        Assert.assertEquals(true, trelloMapper.mapToListDto(trelloLists).get(1).isClosed());
        Assert.assertEquals(2, trelloMapper.mapToListDto(trelloLists).size());
    }

    @Test
    public void testMapperToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Name Dto","Description Dto","Pos Dto","Id Dto");

        //When
        trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals("Name Dto", trelloMapper.mapToCard(trelloCardDto).getName());
        Assert.assertEquals("Description Dto", trelloMapper.mapToCard(trelloCardDto).getDescription());
        Assert.assertEquals("Pos Dto", trelloMapper.mapToCard(trelloCardDto).getPos());
        Assert.assertEquals("Id Dto", trelloMapper.mapToCard(trelloCardDto).getListId());
    }

    @Test
    public void testMapperToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Name", "Description", "Pos", "Id");

        //When
        trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals("Name", trelloMapper.mapToCardDto(trelloCard).getName());
        Assert.assertEquals("Description", trelloMapper.mapToCardDto(trelloCard).getDescription());
        Assert.assertEquals("Pos", trelloMapper.mapToCardDto(trelloCard).getPos());
        Assert.assertEquals("Id", trelloMapper.mapToCardDto(trelloCard).getListId());
    }
}