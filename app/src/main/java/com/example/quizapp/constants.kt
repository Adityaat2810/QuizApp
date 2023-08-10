package com.example.quizapp

object constants {

    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String ="total_questions"
    const val CORRECT_ANSWER:String="correct_answer"

    fun getQuestions():ArrayList<question>{
        val questionList = ArrayList<question>()

        val que1 = question(

            1,"What is real name of actor who play Hulk ? ",
            R.drawable.gh,
            "Tom Hiddleston","Mark Ruffolo","chRis evans",
            "chrias hamesworth",2

        )
        questionList.add(que1)


        val que2 = question(

            2,"What is the name of Thor’s hammer?",
            R.drawable.asdfg,
            "Vanir","Mjolnir","Aesir",
            "Norn",2

        )
        questionList.add(que2)

        val que3 = question(

            3,"During which war did Captain America get his superhuman abilities?",
            R.drawable.cagetsp,
            "Civil War","WW-1","WW-2",
            "The Cold War",3

        )
        questionList.add(que3)


        val que4 = question(

            4,"What is the name of Peter Quill’s home planet?",
            R.drawable.peterquill,
            " Mordor"," Goddricks Hollow","Morag",
            "Earth",4

        )
        questionList.add(que4)


        val que5 = question(

            5,"Which of the following characters did not disappear during the ”blip”?",
            R.drawable.blip,
            "spiderman"," Doctor Strange","Winter Soldier",
            "Rocket",4

        )
        questionList.add(que5)


        val que6 = question(

            6,"What is Thor’s mother’s name?",
            R.drawable.frigga,
            "Frigga","Fridda","feera",
            "Fyra",1

        )
        questionList.add(que6)


        val que7 = question(

            7,"The spider that bit Peter Parker was …",
            R.drawable.smbs,
            "Radioactive","Poisonous","Venomous",
            "Immortal",1

        )
        questionList.add(que7)


        val que8 = question(

            8,"What type of radiation gave Bruce Banner the ability to turn into the Hulk?",
            R.drawable.hjhjhijhk,
            "alpha","beta","gamma",
            "none of the above",3

        )
        questionList.add(que8)


        val que9 = question(

            9,"Who is the first avenger to meet Nick Fury?",
            R.drawable.nfm,
            "captian america","captian marvel","clint",
            "natasha",2

        )
        questionList.add(que9)



        val que10 = question(

            10,"What does Thanos want to bring to the universe",
            R.drawable.balance2,
            "hope","balance","destruction",
            "nothing",2

        )
        questionList.add(que10)


        return questionList
    }
}