package com.geekbrains.tests.presenter.search

import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.repository.GitHubRepository
import com.geekbrains.tests.search.ViewSearchContract
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class SearchPresenterTest {
    @Mock
    private lateinit var repository: GitHubRepository

    @Mock
    private lateinit var viewContract: ViewSearchContract

    private lateinit var searchPresenter: SearchPresenter
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        searchPresenter = SearchPresenter(repository)
    }

    @Test
    fun detailsPresenter_attach() {
        searchPresenter.onAttach(viewContract)
        searchPresenter.searchGitHub("")
        verify(viewContract).displayLoading(true)
        searchPresenter.onDetach()

    }

    @Test
    fun detailsPresenter_detach() {
        searchPresenter.onAttach(viewContract)
        searchPresenter.onDetach()
        searchPresenter.searchGitHub("")
        verify(viewContract, times(0)).displayLoading(true)
    }

}
