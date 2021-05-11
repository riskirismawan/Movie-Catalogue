package com.riski.moviecatalogue.utils

import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.data.MovieEntity
import com.riski.moviecatalogue.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movie = ArrayList<MovieEntity>()

        movie.add(MovieEntity("m1",
            "A Star Is Born",
            R.drawable.poster_a_start_is_born,
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "10/05/2018",
            "Drama, Romance, Music",
            "$36,000,000.00",
            "$433,888,866.00"))

        movie.add(MovieEntity("m2",
            "Alita: Battle Angel",
            R.drawable.poster_alita,
            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            "02/14/2019",
            "Action, Science Fiction, Adventure",
            "$170,000,000.00",
            "$404,852,543.00"))

        movie.add(MovieEntity("m3",
            "Aquaman",
            R.drawable.poster_aquaman,
            "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            "12/21/2018",
            "Action, Adventure, Fantasy",
            "$160,000,000.00",
            "$1,148,461,807.00"))

        movie.add(MovieEntity("m4",
            "Bohemian Rhapsody",
            R.drawable.poster_bohemian,
            "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            "11/02/2018",
            "Music, Drama, History",
            "$52,000,000.00",
            "$894,027,543.00"))

        movie.add(MovieEntity("m5",
            "Cold Pursuit",
            R.drawable.poster_cold_persuit,
            "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            "02/08/2019",
            "Action, Crime, Thriller",
            "$60,000,000.00",
            "$76,419,755.00"))

        movie.add(MovieEntity("m6",
            "Creed II",
            R.drawable.poster_creed,
            "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            "11/21/2018",
            "Drama",
            "$50,000,000.00",
            "$214,215,889.00"))

        movie.add(MovieEntity("m7",
            "Fantastic Beasts: The Crimes of Grindelwald",
            R.drawable.poster_crimes,
            "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            "11/16/2018",
            "Adventure, Fantasy, Drama",
            "$200,000,000.00",
            "$653,355,901.00"))

        movie.add(MovieEntity("m8",
            "Glass",
            R.drawable.poster_glass,
            "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            "01/18/2019",
            "Thriller, Drama, Science Fiction",
            "$20,000,000.00",
            "$246,941,965.00"))

        movie.add(MovieEntity("m9",
            "How to Train Your Dragon: The Hidden World",
            R.drawable.poster_how_to_train,
            "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            "01/09/2019",
            "Animation, Family, Adventure",
            "$129,000,000.00",
            "$517,526,875.00"))

        movie.add(MovieEntity("m10",
            "Avengers: Infinity War",
            R.drawable.poster_infinity_war,
            "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            "04/27/2018",
            "Adventure, Action, Science Fiction",
            "$300,000,000.00",
            "$2,046,239,637.00"))

        movie.add(MovieEntity("m11",
            "Mary Queen of Scots",
            R.drawable.poster_marry_queen,
            "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
            "12/21/2018",
            "Drama, History",
            "$25,000,000.00",
            "$37,807,625.00"))

        movie.add(MovieEntity("m12",
            "Master Z: Ip Man Legacy",
            R.drawable.poster_master_z,
            "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
            "12/26/2018",
            "Action",
            "-",
            "$21,832,649.00"))

        movie.add(MovieEntity("m13",
            "Mortal Engines",
            R.drawable.poster_mortal_engines,
            "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
            "12/14/2018",
            "Adventure, Science Fiction",
            "$100,000,000.00",
            "$83,672,673.00"))

        movie.add(MovieEntity("m14",
            "Overlord",
            R.drawable.poster_overlord,
            "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            "11/09/2018",
            "Horror, War, Science Fiction",
            "$38,000,000.00",
            "$41,657,844.00"))

        movie.add(MovieEntity("m15",
            "Ralph Breaks the Internet",
            R.drawable.poster_ralph,
            "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
            "11/21/2018",
            "Family, Animation, Comedy, Adventure",
            "$175,000,000.00",
            "$529,221,154.00"))

        movie.add(MovieEntity("m16",
            "Robin Hood",
            R.drawable.poster_robin_hood,
            "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            "11/21/2018",
            "Adventure, Action, Thriller",
            "$100,000,000.00",
            "$86,493,046.00"))

        movie.add(MovieEntity("m17",
            "Serenity",
            R.drawable.poster_serenity,
            "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            "01/25/2019",
            "Thriller, Mystery, Drama",
            "$25,000,000.00",
            "$14,454,622.00"))

        movie.add(MovieEntity("m18",
            "Spider-Man: Into the Spider-Verse",
            R.drawable.poster_spiderman,
            "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            "12/14/2018",
            "Action, Adventure, Animation, Science Fiction, Comedy",
            "$90,000,000.00",
            "$375,540,831.00"))

        movie.add(MovieEntity("m19",
            "T-34",
            R.drawable.poster_t34,
            "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            "01/01/2019",
            "War, Action, Drama, History",
            "$8,000,000.00",
            "$36,220,872.00"))

        return movie
    }

    fun generateDummyTvShows(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity("ts1",
            "Arrow",
            R.drawable.poster_arrow,
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "10/10/2012",
            "Crime, Drama, Mystery, Action & Adventure"))

        tvShow.add(TvShowEntity("ts2",
            "Doom Patrol",
            R.drawable.poster_doom_patrol,
            "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            "02/15/2019",
            "Sci-Fi & Fantasy, Comedy, Drama"))

        tvShow.add(TvShowEntity("ts3",
            "Dragon Ball",
            R.drawable.poster_dragon_ball,
            "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            "02/26/1986",
            "Animation, Action & Adventure, Sci-Fi & Fantasy"))

        tvShow.add(TvShowEntity("ts4",
            "Fairy Tail",
            R.drawable.poster_fairytail,
            "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            "10/12/2009",
            "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery"))

        tvShow.add(TvShowEntity("ts5",
            "Family Guy",
            R.drawable.poster_family_guy,
            "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            "01/31/1999",
            "Animation, Comedy"))

        tvShow.add(TvShowEntity("ts6",
            "The Flash",
            R.drawable.poster_flash,
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            "10/07/2014",
            "Drama, Sci-Fi & Fantasy"))

        tvShow.add(TvShowEntity("ts8",
            "Gotham",
            R.drawable.poster_gotham,
            "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            "09/22/2014",
            "Drama, Crime, Sci-Fi & Fantasy"))

        tvShow.add(TvShowEntity("ts9",
            "Grey's Anatomy",
            R.drawable.poster_grey_anatomy,
            "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            "03/27/2005",
            "Drama"))

        tvShow.add(TvShowEntity("ts10",
            "Hanna",
            R.drawable.poster_hanna,
            "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            "03/28/2019",
            "Action & Adventure, Drama"))

        tvShow.add(TvShowEntity("ts11",
            "Marvel's Iron Fist",
            R.drawable.poster_iron_fist,
            "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            "03/17/2017",
            "Action & Adventure, Drama, Sci-Fi & Fantasy"))

        tvShow.add(TvShowEntity("ts12",
            "Naruto Shippūden",
            R.drawable.poster_naruto_shipudden,
            "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            "02/15/2007",
            "Animation, Action & Adventure, Sci-Fi & Fantasy"))

        tvShow.add(TvShowEntity("ts13",
            "NCIS",
            R.drawable.poster_ncis,
            "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            "09/23/2003",
            "Crime, Action & Adventure, Drama"))

        tvShow.add(TvShowEntity("ts14",
            "Riverdale",
            R.drawable.poster_riverdale,
            "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            "01/26/2017",
            "Mystery, Drama, Crime"))

        tvShow.add(TvShowEntity("ts15",
            "Shameless",
            R.drawable.poster_shameless,
            "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
            "01/09/2011",
            "Drama, Comedy"))

        tvShow.add(TvShowEntity("ts16",
            "Supergirl",
            R.drawable.poster_supergirl,
            "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            "10/26/2015",
            "Drama, Sci-Fi & Fantasy, Action & Adventure"))

        tvShow.add(TvShowEntity("ts17",
            "Supernatural",
            R.drawable.poster_supernatural,
            "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
            "09/13/2005",
            "Drama, Mystery, Sci-Fi & Fantasy"))

        tvShow.add(TvShowEntity("ts18",
            "The Simpsons",
            R.drawable.poster_the_simpson,
            "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            "12/17/1989",
            "Family, Animation, Comedy"))

        tvShow.add(TvShowEntity("ts19",
            "The Umbrella Academy",
            R.drawable.poster_the_umbrella,
            "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            "02/15/2019",
            "Action & Adventure, Sci-Fi & Fantasy, Drama"))

        tvShow.add(TvShowEntity("ts20",
            "The Walking Dead",
            R.drawable.poster_the_walking_dead,
            "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            "10/31/2010",
            "Action & Adventure, Drama, Sci-Fi & Fantasy"))

        return tvShow
    }

}