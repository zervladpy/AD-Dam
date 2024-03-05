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
import com.zervlad.appnba.Core.Services.DependenciesManagerNBA;
import com.zervlad.appnba.Core.Services.EntityManagerNBA;
import com.zervlad.appnba.Core.Services.GsonManagerNBA;
import com.zervlad.appnba.Utils.Constraints.ApiConstraints;
import com.zervlad.appnba.Utils.Constraints.Urls;
import jakarta.persistence.EntityManagerFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class AppNBA extends Application {

    public static void main(String[] args) throws URISyntaxException, IOException {

        // --- Setup Dependency Injection --- //
        setup();

        // --- Load Data --- //
        onStartLoadData();

        launch();
    }

    private static void setup() {

        var apiKey = ApiConstraints.API_KEY_VALUE;

        // --- Dependencies Manager --- //
        DependenciesManagerNBA di = DependenciesManagerNBA.getInstance();

        // --- GSON --- //
        Gson gson = GsonManagerNBA.getInstance();
        di.addDependency(Gson.class, gson);

        // --- Entity Manager --- //
        EntityManagerFactory entityManagerFactory = EntityManagerNBA.getEntityManagerFactory();

        // --- Team Repository --- //
        TeamAPI teamAPI = new TeamAPI(gson, apiKey, Urls.TEAMS);
        TeamDAO teamDAO = new TeamDAO(entityManagerFactory);
        di.addDependency(TeamRepository.class, new TeamRepository(teamDAO, teamAPI));

        // --- Player Repository --- //

        PlayerDAO playerDAO = new PlayerDAO(entityManagerFactory);
        PlayerAPI playerAPI = new PlayerAPI(gson, apiKey, Urls.PLAYERS);
        di.addDependency(PlayerRepository.class, new PlayerRepository(playerDAO, playerAPI));

        // --- Game Repository --- //
        GameDAO gameDAO = new GameDAO(entityManagerFactory);
        GameAPI gameAPI = new GameAPI(gson, apiKey, Urls.GAMES);
        di.addDependency(GameRepository.class, new GameRepository(gameDAO, gameAPI));


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

