package org.example.data;

import com.google.gson.Gson;
import org.example.business.Curso;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private final String archivo = "data/cursos.json";
    private final Gson gson = new Gson();

    public List<Curso>listar(){
        try (Reader reader = new FileReader(archivo)){
            Type tipo = new TypeToken<List<Curso>>(){}.getType();
            List<Curso> cursos = gson.fromJson(reader, tipo);
            return cursos!= null? cursos: new ArrayList<>();

        }catch (Exception e){
            return new ArrayList<>();

        }
    }
    public  void guardar (List<Curso>cursos){
        new File("data").mkdirs();
        try(Writer writer = new FileWriter(archivo)){
            gson.toJson(cursos, writer);

        }catch (Exception e){
            System.out.println("Error al guardar Curso");

        }
    }
}
