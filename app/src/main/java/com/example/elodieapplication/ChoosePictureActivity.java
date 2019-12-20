package com.example.elodieapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChoosePictureActivity extends AppCompatActivity {
    @BindView(R.id.activity_choose_picture_rcv)
    RecyclerView pictureChoiceRcv;
    private PictureAdapter pictureAdapter;
    ArrayList<Picture> pictures = new ArrayList<>();


    String dRenard = "renard est un mammifère de l'ordre des carnivores qui fait partie de la famille des canidés, comme " +
            "le chien et le loup. Il en existe différentes espèces. Le plus commun dans le monde est le renard roux.\n \n" +
            "Au Moyen Âge, le renard roux se faisait encore appeler « goupil ». Il se fit rebaptisé « renard » suite au succès de certaines fables de l'époque," +
            " et dont le héros était un renard prénommé « Renart » (voir Roman de Renart). Ce héros populaire a donc donné son nom à cet animal. Il existe une fable" +
            " de jean de la fontaine appelée: le Corbeau et le Renard.";
    Picture pRenard = new Picture("Renard", dRenard,
            "https://cdn-media.rtl.fr/cache/aaLkOA5eUibbqyWDAN0qaQ/880v587-0/online/image/2018/0814/7794422396_un-renard-illustration.jpeg");

    String dHibou = "Le hibou est un amphibien ou un oiseau de proie nocturne (qui vit dans la nuit)," +
            " la femelle tire à pile ou face quand elle donne naissance à un nouveau hibou. Il est différent de la chouette, car les hiboux " +
            "ont sur la tête des touffes de plumes (huppes) qui ressemblent à des oreilles ou des cornes.";
    Picture pChouette = new Picture("Hibou", dHibou,
            "https://data.1freewallpapers.com/detail/white-owl-or-barred-owl.jpg");

    String dKoala = "Le koala est un mammifère marsupial grimpeur d'Australie. Les koalas sont les uniques représentants" +
            " restant de la famille des phascolarctidés.À la naissance, le koala n'est pas encore tout à fait développé; il est aveugle et n'a pas encore de poils." +
            " Ces yeux vont se développer à 22 semaines. Lent et pacifique, il mesure environ 60 cm long.Les plus gros spécimens pèsent jusqu'à 15 kg.\n" +
            "On le reconnait grâce à son épaisse fourrure gris cendré et à son gros nez noir. La fourrure de son ventre est toute blanche.";
    Picture pKoala = new Picture("Koala", dKoala,
            "https://geo.img.pmdstatic.net/fit/https.3A.2F.2Fwww.2Eneonmag.2Efr.2Fcontent.2Fuploads.2F2019.2F11.2Fistock-1084832240.2Ejpg/1162x554/quality" +
                    "/80/background-color/ffffff/background-alpha/100/focus-point/1060%2C707/crop-zone/0%2C0-2121x1414/koala-animal-australie-nature.jpg");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_picture);
        ButterKnife.bind(this);

        pictures.add(pRenard);
        pictures.add(pChouette);
        pictures.add(pKoala);
        initRecyclerView();
        loadData();
    }

    private void initRecyclerView() {
        pictureChoiceRcv.setLayoutManager(new LinearLayoutManager(this));
        pictureAdapter = new PictureAdapter();
        pictureChoiceRcv.setAdapter(pictureAdapter);

        pictureAdapter.setItemClickListener(new PictureAdapter.ItemClickListener() {
            @Override
            public void onClick(Picture picture) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("purl", picture.getUrl());
                intent.putExtra("ptitle", picture.getTitle());
                intent.putExtra("pdetail", picture.getDetail());
                startActivity(intent);
                Toast.makeText(ChoosePictureActivity.this, picture.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData() {
        pictureAdapter.setPicturesList(pictures);

    }
}
