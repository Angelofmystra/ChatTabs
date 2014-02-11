package chatter;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TabPane;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
 
/**
 * An implementation of tabs using the TabPane class. This class essentially creates and holds a list of ChatTabs.
 * @author bertrandbrompton
 * @see javafx.scene.control.TabPane
 * @see javafx.scene.control.Tab
 */
public class ChatTabList extends Application {
    final TabPane tabPane = new TabPane(); // put here so that the Event Handler can see it   
    
    private void init(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setScene(new Scene(root));
        BorderPane borderPane = new BorderPane();      
        
        tabPane.setPrefSize(800, 600);
        tabPane.setSide(Side.BOTTOM);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);

        createTab("Mattyftw");
        createTab("Dracs von Mordenheim");
        createTab("Backstabber");
        createTab("Paul Massey");

        Button btn = new Button(); // The purpose of this button, even though its poorly placed, is to demonstrate that the chat client can add new tabs. Thus accomodating merging with the FriendList functionality.
        btn.setText("Meet a friend");
        btn.setOnAction(chatWithFriendHandler());
        
        borderPane.setCenter(tabPane);
        root.getChildren().addAll(borderPane, btn);

    }
    public void createTab(String playerName){
        ChatTab tab = new ChatTab(playerName);
        tabPane.getTabs().add(tab.getTab());
    }
    public EventHandler chatWithFriendHandler(){
        EventHandler evh = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				        createTab("Stranger Danger");
			}
        };
        return evh;    	
    }    
    @Override public void start(Stage primaryStage) throws Exception {
        init(primaryStage);
        primaryStage.show();
    }
    public static void main(String[] args) { launch(args); }
}