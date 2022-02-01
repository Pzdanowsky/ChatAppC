package Services;

import Objects.*;
import Services.Builders.*;

public class PreparationObjectsService {

    public static ObjectData preparationLoginObject(){
        ObjectDataBuilder objectBuilder = new LoginObjectBuilder();
        objectBuilder.makeUserData();
        objectBuilder.makeCommandType();
        objectBuilder.makeDataType();
        objectBuilder.makeAuthStatus();
        return objectBuilder.getObjectData();
    }

    public static ObjectData preparationRegisterObject(){
        ObjectDataBuilder objectDataBuilder = new RegisterObjectBuilder();
        objectDataBuilder.makeUserData();
        objectDataBuilder.makeCommandType();
        objectDataBuilder.makeAuthStatus();
        return objectDataBuilder.getObjectData();
    }

    public static ObjectData preparationSearchUserObject(String username){
        ObjectDataBuilder objectDataBuilder = new SearchUserObjectBuilder();
        objectDataBuilder.makeUserData();
        objectDataBuilder.makeUserDataDestination(username);
        objectDataBuilder.makeCommandType();
        objectDataBuilder.makeDataType();
        objectDataBuilder.makeAuthStatus();
        return objectDataBuilder.getObjectData();
    }

    public static ObjectData preparationCreateChatObject(String username){
        ObjectDataBuilder objectDataBuilder = new CreateChatObjectBuilder();
        objectDataBuilder.makeUserData();
        objectDataBuilder.makeUserDataDestination(username);
        objectDataBuilder.makeCommandType();
        objectDataBuilder.makeDataType();
        objectDataBuilder.makeAuthStatus();
        return objectDataBuilder.getObjectData();
    }

    public static ObjectData preparationSendMessageObject(MessageObject messageObject){
        ObjectDataBuilder objectDataBuilder = new SendMessageObjectBuilder();
        objectDataBuilder.makeUserData();
        objectDataBuilder.makeMessageObject(messageObject);
        objectDataBuilder.makeCommandType();
        objectDataBuilder.makeDataType();
        objectDataBuilder.makeAuthStatus();
        return objectDataBuilder.getObjectData();
    }

    public static ObjectData preparationRequestContactList(){
        ObjectDataBuilder objectDataBuilder = new ContactListObjectBuilder();
        objectDataBuilder.makeUserData();
        objectDataBuilder.makeCommandType();
        objectDataBuilder.makeDataType();
        objectDataBuilder.makeAuthStatus();
        return objectDataBuilder.getObjectData();
    }


    public static ObjectData preparationRequestMessageList(Chat chatRoom) {
        ObjectDataBuilder objectDataBuilder = new MessageListObjectBuilder();
        objectDataBuilder.makeUserData();
        objectDataBuilder.makeCommandType();
        objectDataBuilder.makeDataType();
        objectDataBuilder.addChatToList(chatRoom);
        objectDataBuilder.makeAuthStatus();
        return objectDataBuilder.getObjectData();
    }
}
