package com.eghasp.biomedtech
import android.accounts.AbstractAccountAuthenticator
import android.accounts.Account
import android.accounts.AccountAuthenticatorResponse
import android.os.Bundle
import android.content.Context



object TechData {
    private val techName = arrayOf("AED (Automated External Defibrillator)",
            "Mesin Anastesi",
            "Chemistry Analyzer",
            "CT Scan (Computerized Tomography Scan)",
            "ECG (Electrocardiogram)",
            "ESU (Electrosurgical Unit)",
            "MRI (Magnetic Resonance Imaging)",
            "USG (Ultrasonography)",
            "Ventilator",
            "X-Ray/Rontgen")

    private val techDetails = arrayOf("Sebuah alat medis yang dapat menganalisis irama jantung secara otomatis dan memberikan kejutan listrik untuk mengembalikan irama jantung jika dibutuhkan.\n\nFungsi:\nAlat ini berfungsi untuk menolong orang yang mengalami henti jantung.\n\nPrinsip Kerja:\nDefibrillator bekerja dengan cara mengirim aliran listrik atau sengatan listrik ke tubuh dengan dosis tertentu yang bertujuan untuk meyebabkan depolarisasi otot jantung sehingga menyebabkan melemasnya otot dan memproduksi kelistrikan jantung agar jantung kembali berdetak ",
            "Alat-alat anastesi dan perlengkapannya yang digunakan untuk melakukan tindakan anastesi umum secara inhalasi.\n\nFungsi:\nMengeluarkan gas atau campuran gas anestetik yang tergolong aman ke rangkaian sirkuit anestetik yang kemudian bertujuan untuk dihirup oleh pasien yang sudah sesuai dengan indikasi, serta berfungsi untuk membuang sisa campuran gas yang dikeluarkan dari tubuh pasien tersebut.\n\nPrinsip Kerja:\nUap dari obat anastesi dihirup masuk melalui paru-paru kemudian menembus membran alveoli kapiler kemudian masuk ke darah kapiler menuju sirkulasi ke jantung kemudian ke otak. Setelah itu obat akan menembus kapiler di jaringan otak dan masuk ke dalam selsel otak sehingga kesadaran pada diri pasien menurun.",
            "Alat kimia klinik darah yang digunakan untuk menganalisa dan mengecek unsur-unsur yang terkandung dalam darah.\n\nFungsi:\nUntuk menganalisis kandungan gas, air, mineral, logam, serta materi biologis dari suatu larutan di dalamnya.\n\nPrinsip Kerja:\nSampel yang telah diintubasi kemudian dimasukkan ke dalam mesin melalui selang aspirator lalu sampel masuk ke dalam kuvet untuk disinari dengan cahaya lampu photommeter yang kemudian proses hamburan cahaya ditangkap oleh sensor-sensor. Dari situ dibawa oleh sistem menjadi sebuah data intensitas cahaya yang sudah terhambur. Dengan sistem control dan standar yang sudah diprogram akan diperoleh data hasil pengukurannya.",
            "Pemeriksaan medis dengan menggunakan kombinasi teknologi Rontgen atau sinar-X dan sistem komputer khusus untuk melihat kondisi dalam tubuh dari berbagai sudut dan potongan.\n\nFungsi:\n•\tMemperoleh diagnosis kelainan otot dan tulang,.\n" +
                    "•\tMenentukan lokasi tumor, infeksi, atau bekuan darah.\n" +
                    "•\tMemandu prosedur medis ketika melakukan operasi, biopsi, atau terapi radiasi.\n" +
                    "•\tMendeteksi dan memonitor kondisi dan penyakit tertentu.\n" +
                    "•\tMencari tahu cedera atau pendarahan internal.\n\nPrinsip Kerja:\nCT Scanner menggunakan penyinaran khusus yang dihubungkan dengan komputer berdaya tinggi yang berfungsi memproses hasil scan untuk memperoleh gambaran panampang-lintang dari badan. Pasien dibaringkan diatas suatu meja khusus yang secara perlahan–lahan dipindahkan ke dalam cincin CT Scan. Scanner berputar mengelilingi pasien pada saat pengambilan sinar rontgen.",
            "Mesin yang dapat membantu mendiagnosis berbagai kondisipenyakit jantung.\n\nFungsi:\nMelakukan diagnosis terhadap fungsi kerja jantung.\n\nPrinsip Kerja:\nPrinsip kerja ECG yaitu dengan menggunakan tes pendeteksi impuls listril. ECG ini menerjemahkan impuls listrik yang dihasilkan oleh jantung menjadi grafik yang nantinya dapat dilihat di layar LCD. Serta penggunaannya tidak menyakitkan dikarenakan alat ini tidak mengalirkan arus listrik ke dalam tubuh dan tanpa sayatan (bedah). Agar jantung dapat memompa darah ke seluruh tubuh melewati bilik maka dibutuhkan rangsangan listrik. Semua perintah yang dihasilkan di setiap siklus aliran darah sangat berpengaruh terhadap gejala dan kardiovaskuler.",
            "Alat bedah yang bekerja dengan memanfaatkan arus listrik berfrekuensi tinggi.\n\nFungsi:\nBiasa digunakan untuk pembedahan.\n\nPrinsip Kerja:\nMengalirkan arus listrik melalui suatu jaringan. Saat penggunaan ESU, memanfaatkan arus listrik dengan frekuensi tinggi yang berfungsi memaksimalkan efek panas (thermal) dan mencegah efek faradic dan efek ekrolitik.",
            "Pemeriksaan yang memanfaatkan medan magnet dan energi gelombang radio untuk menampilkan gambar struktur dan organ dalam tubuh.\n\nFungsi:\n•\tMendeteksi cedera kepala, kanker, stroke, kerusakan pembuluh darah, pada otak, tumor, cedera saraf tulang belakang, kelainan pada mata atau telinga bagian dalam, serta multiple sclerosis.\n" +
                    "•\tMendeteksi penyakit jantung, kerusakan jantung pasca serangan jantung.\n" +
                    "•\tMendeteksi penyakit pada tulang dan sendi\n" +
                    "•\tmemeriksa kelainan pada payudara, rahim dan indung telur, hati, saluran empedu, limfa, ginjal, pankreas, ataupun prostat.\n\nPrinsip Kerja:\nMesin MRI memaparkan serangkaian energi gelombang radio (RF) yang menyebabkan hanya atom hidrogen yang tereksitasi. Saat atom hidrogen yang tereksitasi berusaha kembali ke posisi di sepanjang medan magnet yang dihasilkan mesin, atom-atom tersebut melepaskan kelebihan energi yang diambil dari gelombang RF. Mesin MRI kemudian mendeteksi dan mencatat pelepasan energi tersebut. Dalam beberapa kasus, pasien sering diminta untuk menelan atau mendapatkan suntikan agen kontras (seperti gadolinium) sebelum proses pemindaian sehingga gambar MRI yang dihasilkan memiliki resolusi yang lebih baik dan memudahkan analisis.",
            "Prosedur pencitraan menggunakan teknologi gelombang suara berfrekuensi tinggi untuk memproduksi gambar tubuh bagian dalam, seperti organ tubuh atau jaringan lunak.\n\nFungsi:\nUSG dapat digunakan sebagai alat diagnosis penyakit, memonitor kondisi janin, dan sebagai alat bantu saat proses pembedahan atau tindakan tertentu, seperti pengambilan sampel jaringan (biopsi).\n\nPrinsip Kerja:\nUSG umumnya menggunakan alat bernama transducer yang ditempelkan di kulit. Alat ini nantinya akan memancarkan gelombang suara dengan frekuensi tinggi. Dalam pemeriksaan ini, transducer akan digerak-gerakkan di bagian tubuh yang akan diperiksa. Gerakan ini bertujuan agar gelombang suara yang dikirim mampu memantul kembali dan memunculkan gambar dengan baik. Nantinya, tiap gema yang memantul ini akan membentuk gambar berupa bentuk, ukuran, dan konsistensi dari jaringan lunak atau organ dalam tubuh. Pantulan inilah yang akan membentuk gambar di layar komputer.",
            "Mesin yang berfungsi untuk menunjang atau membantu pernapasan. Ventilator sering kali dibutuhkan oleh pasien yang tidak dapat bernapas sendiri, baik karena suatu penyakit atau karena cedera yang parah.\n\nFungsi:\n•\tPemulihan setelah operasi: beberapa pasien membutuhkan ventilator untuk bernapas setelah operasi\n" +
                    "•\tKoma atau tidak sadarkan diri\n" +
                    "•\tParu-paru kolaps\n" +
                    "•\tOverdosis obat\n" +
                    "•\tInfeksi paru-paru\n" +
                    "•\tPneumonia\n" +
                    "•\tCedera tulang belakang bagian atas\n" +
                    "•\tInfeksi virus corona (Covid-19)\n\nPrinsip Kerja:\nAlat ventilator digunakan untuk mengalirkan oksigen ke paru-paru dan tubuh. Selain itu, ventilator juga membantu mengeluarkan karbondioksida dari dalam tubuh. Ventilator dipasang dengan menghubungkan mesin ke saluran pernapasan seseorang lewat selang ventilator. Selang ini dipasang melalui mulut, hidung, atau lewat lubang yang dibuat di bagian depan leher pasien.",
            "Salah satu teknik pencitraan medis yang menggunakan radiasi elektromagnetik untuk mengambil gambar atau foto bagian dalam tubuh.\n\nFungsi:\nUntuk melihat kondisi sebagian besar bagian tubuh, termasuk masalah pada organ dalam. Contoh-contoh kondisi yang dapat ditampilkan melalui foto Rontgen antara lain adalah kondisi pada tulang dan sendi (misalnya patah tulang dan osteoporosis), infeksi, gangguan pencernaan, pembengkakan jantung, serta tumor payudara.\n\nPrinsip Kerja:\nMesin akan mengirimkan gelombang radiasi elektromagnetik secara singkat ke tubuh untuk memindai kondisi tubuh bagian dalam. Radiasi yang diserap oleh masing-masing bagian tubuh akan berbeda-beda. Jika mengenai logam atau bagian tubuh yang padat seperti tulang, sebagian besar partikel X-Ray terblokir. Hasil pemeriksaan X-Ray pun akan tampak berwarna putih. Bila X-Ray mengenai otot, lemak, dan cairan, hasil pemeriksaan X-Ray akan muncul dengan warna abu-abu. Warna hitam menandakan bahwa X-Ray mengenai udara.")

    private val techImages = intArrayOf(R.drawable.aed,
            R.drawable.anastesi,
            R.drawable.chemistry_analyzer,
            R.drawable.ct_scan,
            R.drawable.ecg,
            R.drawable.esu,
            R.drawable.mri,
            R.drawable.usg,
            R.drawable.ventilator,
            R.drawable.xray)

    val listData: ArrayList<tech>

    get() {
        val list = arrayListOf<tech>()
        for (position in techName.indices){
            val techs = tech()
            techs.name = techName[position]
            techs.detail = techDetails[position]
            techs.photo = techImages[position]
            list.add(techs)
        }
        return list
    }
}