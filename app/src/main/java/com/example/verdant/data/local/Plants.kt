package com.example.verdant.data.local

import android.content.Context
import com.example.verdant.R
import com.example.verdant.data.Plant

object Plants {
    //val defaultPlant = getPlantsList()[0]

    fun getPlant(
        id: Int,
        context: Context
    ): Plant = getPlantsList(context).find {
        it.id == id
    }!!

    fun getPlantsList(context: Context): List<Plant>{
        return listOf(
            Plant(
                id = 0,
                name = "Angelica",
                category = "Medicinal",
                poisonous = null,
                description = R.string.decription_0,
                medicinal = R.string.use_0,
                warning = null,
                photo = R.drawable.angelica_1
            ),

            Plant(
                id = 1,
                name = "Arnica",
                category = "Medicinal",
                description = R.string.decription_1,
                medicinal = R.string.use_1,
                poisonous = null,
                warning = null,
                photo = R.drawable.arnica_3
            ),

            Plant(
                id = 2,
                name = "Busuioc",
                category = "Medicinal",
                description = R.string.decription_2,
                medicinal = R.string.use_2,
                poisonous = null,
                warning = null,
                photo = R.drawable.busuioc_7
            ),

            Plant(
                id = 3,
                name = "Cimbru",
                category = "Medicinal",
                description = R.string.decription_3,
                medicinal = R.string.use_3,
                poisonous = null,
                warning = null,
                photo = R.drawable.cimbru_13
            ),

            Plant(
                id = 4,
                name = "Cireș",
                category = "Medicinal",
                description = R.string.decription_0,
                medicinal = R.string.use_0,
                poisonous = null,
                warning = R.string.warning_4,
                photo = R.drawable.cires_14
            ),

            Plant(
                id = 5,
                name = "Coada-calului",
                category = "Medicinal",
                description = R.string.decription_5,
                medicinal = R.string.use_5,
                poisonous = null,
                warning = null,
                photo = R.drawable.coada_calului_5
            ),

            Plant(
                id = 6,
                name = "Chimion",
                category = "Medicinal",
                description = R.string.decription_6,
                medicinal = R.string.use_6,
                poisonous = null,
                warning = null,
                photo = R.drawable.chimion_2
            ),

            Plant(
                id = 7,
                name = "Dafin",
                category = "Medicinal",
                description = R.string.decription_7,
                medicinal = R.string.use_7,
                poisonous = null,
                warning = null,
                photo = R.drawable.dafin_9
            ),

            Plant(
                id = 8,
                name = "Dud",
                category = "Medicinal",
                description = R.string.decription_8,
                medicinal = R.string.use_8,
                poisonous = null,
                warning = null,
                photo = R.drawable.dud_3
            ),

            Plant(
                id = 9,
                name = "Echinaceea",
                category = "Medicinal",
                description = R.string.decription_9,
                medicinal = R.string.use_9,
                poisonous = null,
                warning = null,
                photo = R.drawable.echinaceea_3
            ),

            Plant(
                id = 10,
                name = "Soc negru",
                category = "Medicinal",
                description = R.string.decription_22,
                medicinal =  R.string.use_22,
                poisonous = null,
                warning = null,
                photo = R.drawable.floare_soc_1
            ),

            Plant(
                id = 11,
                name = "Galbenele",
                category = "Medicinal",
                description = R.string.decription_11,
                medicinal = R.string.use_11,
                poisonous = null,
                warning = null,
                photo = R.drawable.galbenele_6
            ),

            Plant(
                id = 12,
                name = "Ghimbir",
                category = "Medicinal",
                description = R.string.decription_12,
                medicinal = R.string.use_12,
                poisonous = null,
                warning = null,
                photo = R.drawable.ghimbir_14
            ),

            Plant(
                id = 13,
                name = "Izmă",
                category = "Medicinal",
                description = R.string.decription_13,
                medicinal = R.string.use_13,
                poisonous = null,
                warning = null,
                photo = R.drawable.izma_9
            ),

            Plant(
                id = 14,
                name = "Lavanda",
                category = "Medicinal",
                description = R.string.decription_14,
                medicinal = R.string.use_14,
                poisonous = null,
                warning = null,
                photo = R.drawable.lavanda_4
            ),

            Plant(
                id = 15,
                name = "Limba mielului",
                category = "Medicinal",
                description = R.string.decription_15,
                medicinal = R.string.use_15,
                poisonous = null,
                warning = null,
                photo = R.drawable.limba_mielului_2
            ),

            Plant(
                id = 16,
                name = "Mărar",
                category = "Medicinal",
                description = R.string.decription_16,
                medicinal = R.string.use_16,
                poisonous = null,
                warning = null,
                photo = R.drawable.marar_1
            ),

            Plant(
                id = 17,
                name = "Mesteacăn",
                category = "Medicinal",
                description = R.string.decription_17,
                medicinal = R.string.use_17,
                poisonous = null,
                warning = null,
                photo = R.drawable.mesteacan_1
            ),

            Plant(
                id = 18,
                name = "Mușețel",
                category = "Medicinal",
                description = R.string.decription_18,
                medicinal = R.string.use_18,
                poisonous = null,
                warning = null,
                photo = R.drawable.musetel_1
            ),

            Plant(
                id = 19,
                name = "Năpraznic",
                category = "Medicinal",
                description = R.string.decription_19,
                medicinal = R.string.use_19,
                poisonous = null,
                warning = null,
                photo = R.drawable.napraznic_1
            ),

            Plant(
                id = 20,
                name = "Pătlagină",
                category = "Medicinal",
                description = R.string.decription_20,
                medicinal = R.string.use_20,
                poisonous = null,
                warning = null,
                photo = R.drawable.patlagina_1
            ),

            Plant(
                id = 21,
                name = "Salvie",
                category = "Medicinal",
                description = R.string.decription_21,
                medicinal = R.string.use_21,
                poisonous = null,
                warning = null,
                photo = R.drawable.salvie_1
            ),



            Plant(
                id = 22,
                name = "Sunătoare",
                category = "Medicinal",
                description = R.string.decription_23,
                medicinal = R.string.use_23,
                poisonous = null,
                warning = null,
                photo = R.drawable.sunatoare_1
            ),

            Plant(
                id = 23,
                name = "Talpa gâștei",
                category = "Medicinal",
                description = R.string.decription_24,
                medicinal = R.string.use_24,
                poisonous = null,
                warning = null,
                photo = R.drawable.talpa_gastei_2
            ),

            Plant(
                id = 24,
                name = "Tei",
                category = "Medicinal",
                description = R.string.decription_25,
                medicinal = R.string.use_25,
                poisonous = null,
                warning = null,
                photo = R.drawable.tei_13
            ),

            Plant(
                id = 25,
                name = "Fragă Tătărească",
                category = "Medicinal",
                description = R.string.decription_26,
                medicinal = R.string.use_26,
                poisonous = null,
                warning = null,
                photo = R.drawable.fraga_7
            ),

            Plant(
                id = 26,
                name = "Urzică",
                category = "Medicinal",
                description = R.string.decription_27,
                medicinal = R.string.use_27,
                poisonous = null,
                warning = null,
                photo = R.drawable.urzica_3
            ),

            Plant(
                id = 27,
                name = "Valeriană ",
                category = "Medicinal",
                description = R.string.decription_28,
                medicinal = R.string.use_28,
                poisonous = null,
                warning = null,
                photo = R.drawable.valeriana_2
            ),

            Plant(
                id = 28,
                name = "Coada Șoricelului",
                category = "Medicinal",
                description = R.string.decription_0,
                medicinal = R.string.use_0,
                poisonous = null,
                warning = null,
                photo = R.drawable.coada_soricelului_1
            ),


            Plant(
                id = 29,
                name = "Lăcrămioară",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_29,
                description = R.string.description_29,
                warning = R.string.warning_29,
                photo = R.drawable.lacramioara_2
            ),

            Plant(
                id = 30,
                name = "Omag",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_30,
                description = R.string.description_30,
                warning = R.string.warning_30,
                photo = R.drawable.omag_0
            ),

            Plant(
                id = 31,
                name = "Cucuta",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_31,
                description = R.string.description_31,
                warning = R.string.warning_31,
                photo = R.drawable.cucuta
            ),

            Plant(
                id = 32,
                name = "Leandru",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_32,
                description = R.string.description_32,
                warning = R.string.warning_32,
                photo = R.drawable.leandru
            ),

            Plant(
                id = 33,
                name = "Ricin",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_33,
                description = R.string.description_33,
                warning = R.string.warning_33,
                photo = R.drawable.ricin_1
            ),

            Plant(
                id = 34,
                name = "Mătrăgună",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_34,
                description = R.string.description_34,
                warning = R.string.warning_34,
                photo = R.drawable.matraguna_3
            ),

            Plant(
                id = 35,
                name = "Joian",
                category = "Otrăvitoare",
                medicinal = null,
                poisonous = R.string.uses_35,
                description = R.string.description_35,
                warning = R.string.warning_35,
                photo = R.drawable.joian_3
            )
        )
    }
}