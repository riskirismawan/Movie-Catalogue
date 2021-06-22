package com.riski.moviecatalogue.utils

import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movie = ArrayList<MovieEntity>()

        movie.add(MovieEntity(movieId = 337404,
            title = "A Star Is Born",
            poster = R.drawable.poster_a_start_is_born.toString(),
            overview = "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            releaseDate = "10/05/2018",
            genre = "action",
            budget = 36_000_000,
            revenue = 433_888_866,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 2,
            title = "Alita: Battle Angel",
            poster = R.drawable.poster_alita.toString(),
            overview = "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
            releaseDate = "02/14/2019",
            genre = "",
            budget = 170_000_000,
            revenue = 404_852_543,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 3,
            title = "Aquaman",
            poster = R.drawable.poster_aquaman.toString(),
            overview = "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
            releaseDate = "12/21/2018",
            genre = "",
            budget = 160_000_000,
            revenue = 1_148_461_807,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 4,
            title = "Bohemian Rhapsody",
            poster = R.drawable.poster_bohemian.toString(),
            overview = "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
            releaseDate = "11/02/2018",
            genre = "",
            budget = 52_000_000,
            revenue = 894_027_543,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 5,
            title = "Cold Pursuit",
            poster = R.drawable.poster_cold_persuit.toString(),
            overview = "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
            releaseDate = "02/08/2019",
            genre = "",
            budget = 60_000_000,
            revenue = 76_419_755,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 6,
            title = "Creed II",
            poster = R.drawable.poster_creed.toString(),
            overview = "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
            releaseDate = "11/21/2018",
            genre = "",
            budget = 50_000_000,
            revenue = 214_215_889,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 7,
            title = "Fantastic Beasts: The Crimes of Grindelwald",
            poster = R.drawable.poster_crimes.toString(),
            overview = "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
            releaseDate = "11/16/2018",
            genre = "",
            budget = 200_000_000,
            revenue = 653_355_901,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 8,
            title = "Glass",
            poster = R.drawable.poster_glass.toString(),
            overview = "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
            releaseDate = "01/18/2019",
            genre = "",
            budget = 20_000_000,
            revenue = 246_941_965,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 9,
            title = "How to Train Your Dragon: The Hidden World",
            poster = R.drawable.poster_how_to_train.toString(),
            overview = "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
            releaseDate = "01/09/2019",
            genre = "",
            budget = 129_000_000,
            revenue = 517_526_875,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 10,
            title = "Avengers: Infinity War",
            poster = R.drawable.poster_infinity_war.toString(),
            overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
            releaseDate = "04/27/2018",
            genre = "",
            budget = 300_000_000,
            revenue = 2_046_239_637,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 11,
            title = "Mary Queen of Scots",
            poster = R.drawable.poster_marry_queen.toString(),
            overview = "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
            releaseDate = "12/21/2018",
            genre = "",
            budget = 25_000_000,
            revenue = 37_807_625,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 12,
            title = "Master Z: Ip Man Legacy",
            poster = R.drawable.poster_master_z.toString(),
            overview = "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
            releaseDate = "12/26/2018",
            genre = "",
            budget = 1,
            revenue = 21_832_649,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 13,
            title = "Mortal Engines",
            poster = R.drawable.poster_mortal_engines.toString(),
            overview = "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
            releaseDate = "12/14/2018",
            genre = "",
            budget = 100000000,
            revenue = 83672673,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 14,
            title = "Overlord",
            poster = R.drawable.poster_overlord.toString(),
            overview = "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
            releaseDate = "11/09/2018",
            genre = "",
            budget = 38_000_000,
            revenue = 41_657_844,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 15,
            title = "Ralph Breaks the Internet",
            poster = R.drawable.poster_ralph.toString(),
            overview = "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
            releaseDate = "11/21/2018",
            genre = "",
            budget = 175_000_000,
            revenue = 529_221_154,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 16,
            title = "Robin Hood",
            poster = R.drawable.poster_robin_hood.toString(),
            overview = "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
            releaseDate = "11/21/2018",
            genre = "",
            budget = 100_000_000,
            revenue = 86_493_046,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 17,
            title = "Serenity",
            poster = R.drawable.poster_serenity.toString(),
            overview = "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
            releaseDate = "01/25/2019",
            genre = "",
            budget = 25_000_000,
            revenue = 14_454_622,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 18,
            title = "Spider-Man: Into the Spider-Verse",
            poster = R.drawable.poster_spiderman.toString(),
            overview = "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
            releaseDate = "12/14/2018",
            genre = "",
            budget = 90_000_000,
            revenue = 375_540_831,
            isFavorite = false))

        movie.add(MovieEntity(movieId = 19,
            title = "T-34",
            poster = R.drawable.poster_t34.toString(),
            overview = "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
            releaseDate = "01/01/2019",
            genre = "",
            budget = 8_000_000,
            revenue = 36_220_872,
            isFavorite = false))

        return movie
    }

    fun generateDummyTvShows(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        tvShow.add(TvShowEntity(tvShowId = 1399,
            title = "Arrow",
            poster = R.drawable.poster_arrow.toString(),
            overview = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            firstAirDate = "10/10/2012",
            genre = "action",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 2,
            title = "Doom Patrol",
            poster = R.drawable.poster_doom_patrol.toString(),
            overview = "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
            firstAirDate = "02/15/2019",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 3,
            title = "Dragon Ball",
            poster = R.drawable.poster_dragon_ball.toString(),
            overview = "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
            firstAirDate = "02/26/1986",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 4,
            title = "Fairy Tail",
            poster = R.drawable.poster_fairytail.toString(),
            overview = "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
            firstAirDate = "10/12/2009",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 5,
            title = "Family Guy",
            poster = R.drawable.poster_family_guy.toString(),
            overview = "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
            firstAirDate = "01/31/1999",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 6,
            title = "The Flash",
            poster = R.drawable.poster_flash.toString(),
            overview = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
            firstAirDate = "10/07/2014",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 8,
            title = "Gotham",
            poster = R.drawable.poster_gotham.toString(),
            overview = "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
            firstAirDate = "09/22/2014",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 9,
            title = "Grey's Anatomy",
            poster = R.drawable.poster_grey_anatomy.toString(),
            overview = "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
            firstAirDate = "03/27/2005",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 10,
            title = "Hanna",
            poster = R.drawable.poster_hanna.toString(),
            overview = "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
            firstAirDate = "03/28/2019",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 11,
            title = "Marvel's Iron Fist",
            poster = R.drawable.poster_iron_fist.toString(),
            overview = "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
            firstAirDate = "03/17/2017",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 12,
            title = "Naruto Shippūden",
            poster = R.drawable.poster_naruto_shipudden.toString(),
            overview = "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
            firstAirDate = "02/15/2007",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 13,
            title = "NCIS",
            poster = R.drawable.poster_ncis.toString(),
            overview = "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
            firstAirDate = "09/23/2003",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 14,
            title = "Riverdale",
            poster = R.drawable.poster_riverdale.toString(),
            overview = "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
            firstAirDate = "01/26/2017",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 15,
            title = "Shameless",
            poster = R.drawable.poster_shameless.toString(),
            overview = "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
            firstAirDate = "01/09/2011",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 16,
            title = "Supergirl",
            poster = R.drawable.poster_supergirl.toString(),
            overview = "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
            firstAirDate = "10/26/2015",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 17,
            title = "Supernatural",
            poster = R.drawable.poster_supernatural.toString(),
            overview = "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
            firstAirDate = "09/13/2005",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 18,
            title = "The Simpsons",
            poster = R.drawable.poster_the_simpson.toString(),
            overview = "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
            firstAirDate = "12/17/1989",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 19,
            title = "The Umbrella Academy",
            poster = R.drawable.poster_the_umbrella.toString(),
            overview = "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
            firstAirDate = "02/15/2019",
            genre = "",
            isFavorite = false))

        tvShow.add(TvShowEntity(tvShowId = 20,
            title = "The Walking Dead",
            poster = R.drawable.poster_the_walking_dead.toString(),
            overview = "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
            firstAirDate = "10/31/2010",
            genre = "",
            isFavorite = false))

        return tvShow
    }
    
    fun getDetailMovie(): MovieEntity =
        MovieEntity(movieId = 337404,
            title = "A Star Is Born",
            poster = R.drawable.poster_a_start_is_born.toString(),
            overview = "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            releaseDate = "10/05/2018",
            genre = "action",
            budget = 36_000_000,
            revenue = 433_888_866,
            isFavorite = false)

    fun getDetailTvShow(): TvShowEntity =
        TvShowEntity(tvShowId = 1399,
            title = "Arrow",
            poster = R.drawable.poster_arrow.toString(),
            overview = "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            firstAirDate = "10/10/2012",
            genre = "action",
            isFavorite = false)

}