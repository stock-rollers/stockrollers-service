package edu.cnm.deepdive.stockrollersservice.view;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.node.IntNode;
import edu.cnm.deepdive.stockrollersservice.model.entity.History;
import edu.cnm.deepdive.stockrollersservice.model.pojo.HistoryResponse;
import edu.cnm.deepdive.stockrollersservice.model.pojo.HistoryResponse.HistoryList;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
public class HistoryListSerializer {

  public static class Deserializer extends JsonDeserializer<HistoryList> {

    @Override
    public HistoryList deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException, JsonProcessingException {
      HistoryList historyList = new HistoryList();
      JsonNode node = jsonParser.getCodec().readTree(jsonParser);
      for (Iterator<String> iter = node.fieldNames(); iter.hasNext(); ) {
        String dateString = iter.next();
        JsonNode n = node.get(dateString);
        History history = new History();
        history.setClose(Float.parseFloat(n.get("close").asText()));
        history.setHigh(Float.parseFloat(n.get("high").asText()));
        history.setLow(Float.parseFloat(n.get("low").asText()));
        history.setOpen(Float.parseFloat(n.get("open").asText()));
        history.setVolume(Long.parseLong(n.get("volume").asText()));
        history.setDate(LocalDate.parse(dateString));

        historyList.getHistories().add(history);
      }
//
//      JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//      int id = (Integer) ((IntNode) node.get("id")).numberValue();
//      String itemName = node.get("itemName").asTexet();
//      int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();
      return historyList;
    }

  }


}
