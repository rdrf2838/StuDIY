package com.example.studiy.data;

import android.annotation.SuppressLint;

import com.example.studiy.classes.Person;
import com.example.studiy.R;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private static PersonRepository my_instance;

    // TODO: implement database properly
    // For profile pics, download once from online, then cache.
    private PersonRepository() {
    }

    public static PersonRepository getInstance() {
        if (my_instance == null) my_instance = new PersonRepository();
        return my_instance;
    }


    public List<Person> getPersonList() {
        // Anyhow create people
        @SuppressLint({"NewApi", "LocalSuppress"}) List<String> names = List.of("Kaguya Shinomiya", "Miyuki Shirogane", "Chika Fujiwara", "Yu Ishigami", "Miko Iino", "Ai Hayasaka");
        List<Person> personList = new ArrayList<>();
        @SuppressLint({"NewApi", "LocalSuppress"}) List<String> image_uris = List.of(
                String.valueOf(R.drawable.liw_kaguya),
                String.valueOf(R.drawable.liw_shirogane),
                String.valueOf(R.drawable.liw_chika),
                String.valueOf(R.drawable.liw_ishigami),
                String.valueOf(R.drawable.liw_iino),
                String.valueOf(R.drawable.liw_hayasaka)
        );
//        @SuppressLint({"NewApi", "LocalSuppress"}) List<String> image_uris = List.of(
//                "liw_kaguya.png",
//                "liw_shirogane.png",
//                "liw_chika.png",
//                "liw_ishigami.png",
//                "liw_iino.png",
//                "liw_hayasaka.png"
//        );
        for (int i = 0; i < names.size(); i++) {
            String s = names.get(i);
            String image_uri = image_uris.get(i);
            Person p = new Person();
            p.setName(s);
            p.setJobType("Part-time tutor");
            p.setRating("4.5 (130 reviews)");
            p.setImageUri(image_uri);
            p.setFavourite(false);
            personList.add(p);
        }
        return personList;
    }

}
