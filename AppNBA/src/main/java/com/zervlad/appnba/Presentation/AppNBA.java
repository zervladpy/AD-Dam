package com.zervlad.appnba.Presentation;

import com.google.gson.Gson;
import com.zervlad.appnba.Core.Data.Game.GameAPI;
import com.zervlad.appnba.Core.Data.Game.GameDAO;
import com.zervlad.appnba.Core.Data.Game.GameRepository;
import com.zervlad.appnba.Core.Data.Player.PlayerAPI;
import com.zervlad.appnba.Core.Data.Player.PlayerDAO;
import com.zervlad.appnba.Core.Data.Player.PlayerRepository;
import com.zervlad.appnba.Core.Data.Team.TeamAPI;
import com.zervlad.appnba.Core.Data.Team.TeamDAO;
import com.zervlad.appnba.Core.Data.Team.TeamRepository;
import com.zervlad.appnba.Core.Requets.ApiRequest;
import com.zervlad.appnba.Core.Services.DependenciesManagerNBA;
import com.zervlad.appnba.Core.Services.EntityManagerNBA;
import com.zervlad.appnba.Core.Services.GsonManagerNBA;
import jakarta.persistence.EntityManagerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class AppNBA extends Application {

    public static void main(String[] args) throws URISyntaxException, IOException {

        setup();

        launch();
    }

    private static void setup() {
        // --- Dependencies Manager --- //
        DependenciesManagerNBA di = DependenciesManagerNBA.getInstance();

        // --- ApiRequest --- //
        ApiRequest apiRequest = new ApiRequest(); // Using default API key
        di.addDependency(ApiRequest.class, apiRequest); // Adding dependency to the DI container

        // --- GSON --- //
        Gson gson = GsonManagerNBA.getInstance();
        di.addDependency(Gson.class, gson);

        // --- Entity Manager --- //
        EntityManagerFactory entityManagerFactory = EntityManagerNBA.getEntityManagerFactory();

        // --- Team Repository --- //
        TeamAPI teamAPI = new TeamAPI(apiRequest, gson);
        TeamDAO teamDAO = new TeamDAO(entityManagerFactory);
        di.addDependency(TeamRepository.class, new TeamRepository(teamAPI, teamDAO));

        // --- Player Repository --- //

        PlayerDAO playerDAO = new PlayerDAO(entityManagerFactory);
        PlayerAPI playerAPI = new PlayerAPI(apiRequest, gson);
        di.addDependency(PlayerRepository.class, new PlayerRepository(playerAPI, playerDAO));

        // --- Game Repository --- //
        GameDAO gameDAO = new GameDAO(entityManagerFactory);
        GameAPI gameAPI = new GameAPI(gson, apiRequest);
        di.addDependency(GameRepository.class, new GameRepository(gameAPI, gameDAO));

        // --- Load Data --- //
        onStartLoadData();
    }

    private static void onStartLoadData() {
        DependenciesManagerNBA di = DependenciesManagerNBA.getInstance();

        di.getDependency(TeamRepository.class).getAll();
        di.getDependency(PlayerRepository.class).getAll();
        // di.getDependency(GameRepository.class).getAll();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppNBA.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}

