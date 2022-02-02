package Services;

import Objects.*;
import Services.Builders.*;

public class PreparationObjectsService {

    private static MainObjectBuilder mainObjectBuilder;

    public static ObjectData preparationLoginObject(){
        ObjectDataBuilder loginObject = new LoginObjectBuilder();
        mainObjectBuilder = new ObjectDirectorBuilder(loginObject);
        return mainObjectBuilder.creationObjectData();
    }

    public static ObjectData preparationRegisterObject(){
        ObjectDataBuilder registerObject = new RegisterObjectBuilder();
        mainObjectBuilder = new ObjectDirectorBuilder(registerObject);
        return mainObjectBuilder.creationObjectData();
    }

    public static ObjectData preparationSearchUserObject(String username){
        ObjectDataBuilder searchObject = new SearchUserObjectBuilder(username);
        mainObjectBuilder = new ObjectDirectorBuilder(searchObject);
        return mainObjectBuilder.creationObjectData();
    }

    public static ObjectData preparationCreateChatObject(String username){
        ObjectDataBuilder createChatObject = new CreateChatObjectBuilder(username);
        mainObjectBuilder = new ObjectDirectorBuilder(createChatObject);
        return mainObjectBuilder.creationObjectData();
    }

    public static ObjectData preparationSendMessageObject(MessageObject messageObject){
        ObjectDataBuilder messageCreateObject = new SendMessageObjectBuilder(messageObject);
        mainObjectBuilder = new ObjectDirectorBuilder(messageCreateObject);
        return mainObjectBuilder.creationObjectData();
    }

    public static ObjectData preparationRequestContactList(){
        ObjectDataBuilder contactListObject = new ContactListObjectBuilder();
        mainObjectBuilder = new ObjectDirectorBuilder(contactListObject);
        return mainObjectBuilder.creationObjectData();
    }


    public static ObjectData preparationRequestMessageList(Chat chatRoom) {
        ObjectDataBuilder chatMessagesObject = new MessageListObjectBuilder(chatRoom);
        mainObjectBuilder = new ObjectDirectorBuilder(chatMessagesObject);
        return mainObjectBuilder.creationObjectData();
    }

    public static ObjectData preparationCloseProgram() {
        ObjectDataBuilder closeProgramObject = new CloseProgramRequest();
        mainObjectBuilder = new ObjectDirectorBuilder(closeProgramObject);
        return mainObjectBuilder.creationObjectData();
    }
}
