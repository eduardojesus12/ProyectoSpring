package com.generation.SpringSecurityJWT.controller;

import com.generation.SpringSecurityJWT.model.Post;
import com.generation.SpringSecurityJWT.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PostControllerTest {

    @Test
    @DisplayName("Probando el mockito")
    void testMockito() {
        //mock creation
        List mockedList = mock(List.class);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    @DisplayName("Probando el mockito v2")
    void testMockito2() {
        // Crea un objeto simulado, el parámetro puede ser una clase o una interfaz
        List<String> list = mock(List.class);

        // Establecer el valor de retorno esperado del método
        when(list.get(0)).thenReturn("helloworld");

        String result = list.get(0);

        // Verifica la llamada al método (si se llama a get (0))
        verify(list).get(0);

        // prueba junit
        assertEquals("helloworld", result);
    }

    @Test
    @DisplayName("Pruebas en el post")
    void postSaveTest() {
        PostService postService = mock(PostService.class);

        PostController postController = new PostController(postService);

        Post post = new Post();
        post.setTitle("Pruebas en JUnit con Mockito");
        post.setContent("Contenido del post");

        when(postService.save(any(Post.class))).thenReturn(post);

        Post result = postController.save(post);
        verify(postService, times(1)).save(any(Post.class));

        assertEquals(post.getTitle(), result.getTitle() );


    }

}