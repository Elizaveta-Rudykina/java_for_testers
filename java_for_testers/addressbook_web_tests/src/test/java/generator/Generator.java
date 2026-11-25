package generator;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import model.GroupData;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.File;
import java.util.ArrayList;
import static common.CommonFunctions.randomString;

public class Generator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-c"})
    int count;

    public static void main(String[] args) {
        var generator = new Generator();
        JCommander.newBuilder() //парсер, который будет анализировать командную строку, ему передаются аргументы main
                .addObject(generator)
                .build()
                .parse(args);
        generator.run();
    }

    private void run() {
        var data = generate();
        save(data);
    }
    private Object generate() {
        if(type.equals("groups")) {
            return generateGroups();
        } else if(type.equals("contacts")){
            return generateContacts();
        } else{
            throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
    private Object generateGroups() {
        var result = new ArrayList<GroupData>();
        for(int i=0; i<count; i++) {
            result.add(new GroupData()
                    .withName(randomString(i*10))
                    .withHeader(randomString(i*10))
                    .withFooter(randomString(i*10)));
        }
        return result;
    }
    private Object generateContacts() {
        return null;
    }

    private void save(Object data) {
        if(format.equals("json")) {
            ObjectMapper mapper = JsonMapper.builder() //маппер через builder, чтобы можно было добавить конфигурацию
                    .enable(SerializationFeature.INDENT_OUTPUT) //конфиг, который делает json более читабельным
                            .build();

            mapper.writeValue(new File(output), data);
        } else{
            throw new IllegalArgumentException("Unknown format: " + format);
        }
    }
}
