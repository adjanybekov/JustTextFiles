#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <process.h>

struct node {
    int data;
    struct node *next;
    struct node *prev;
};

struct node2{
 int data2;
 struct node2 *next2;

};
 struct node2  *top=NULL;

void push(int veri){
 struct node2 *ekle_yigin=(struct node2*)malloc(sizeof(struct node2));
 ekle_yigin->data2=veri;
 ekle_yigin->next2=NULL;
   if(top!=NULL){
    ekle_yigin->next2=top;
    top=ekle_yigin;
   }
   printf("\n **((%d))",ekle_yigin->data2);
}

void pop(){
 if(top->data2 == NULL){
    printf("stack caten bos");
 }
 else {
    struct node2 *temp;
    temp=top;
    top=top->next2;
    free(temp);
 }
}

struct node *start=NULL;///Ba?langyç dü?ümü bizim için çok önemli, global de?i?ken olarak tanymladyk ve ba?langyçta NULL atadyk.
struct node *giris=NULL;//(struct node*)malloc(sizeof(struct node));
struct node *cikis=NULL;
struct node *maze=NULL;

struct node* dugum_olustur(int veri)///Dü?üm olusturup return eden fonksiyon
{
    struct node* yeni_dugum = (struct node*)malloc(sizeof(struct node));
    yeni_dugum->data = veri;
    yeni_dugum->next = NULL;
    yeni_dugum->prev = NULL;

    return yeni_dugum;
}
int say=0;
void ekle(int veri,int satir , int sutun)  ///Çift yönlü ba?ly listede sona dü?üm ekleyen fonksiyon
{
    struct node* eklenecek = dugum_olustur(veri);

    if (start == NULL){ ///E?er listede hiç eleman yoksa yeni eleman ekliyoruz
        start = eklenecek;
        say++;
    }

    else{///traverse etmek için temp de?i?kenine start de?i?kenini atadyk, maksat start de?i?kenini bozmamak.
         ///A?a?ydaki döngü traverse yapyyor ve temp dü?ümü döngü sonunda son dü?üm oluyor.
       struct node* temp = start;
        while (temp->next != NULL){
            temp = temp->next;
        }
        ///temp elemany (eski son) oldu?u için sonaEklenecek (yeni son) dü?ümünün prev i?aretçisi tempi gösterecek.
        eklenecek->prev = temp;

        ///temp de?i?keninin next i?aretçisi ise artyk yeni son elemanymyz olan sonaEklenecek dü?ümünü i?aret edecek.
        temp->next = eklenecek;
say++;
    }
    printf("%3d",eklenecek->data);
    if((sutun*satir)==say){
    if( eklenecek->prev!=NULL){
           // printf("\n((%d))\n",eklenecek->prev->data );
          //printf("[[%d]]",eklenecek->prev->prev->data);
}
}
    }

 void labirent_giris(int satir , int sutun){

//struct node *giris=(struct node*)malloc(sizeof(struct node));
   giris=start;
   int sayac=0,g_satir,g_sutun;
 printf("Labirente nereden girilsin (../..)\n");   scanf("%d %d",&g_satir,&g_sutun);
 //printf("%d",start->next->data);
  if(g_satir==0&& g_sutun!=sutun-1){   ///en üstten giris
    while(sayac<g_sutun){
        giris=giris->next;
        sayac++;
    }
  }
  sayac=0;
 if(g_sutun==0 && g_satir!=satir-1){   ///soldan giris
    while(sayac<(g_satir)*sutun){
        giris=giris->next;
        sayac++;
    }
 }
 sayac=0;
 if(g_sutun==(sutun-1) && g_satir!=satir-1){ ///sagdan giris
    while(sayac<(sutun*g_satir)+g_sutun){
        giris=giris->next;
        sayac++;
    }
 }
 sayac=0;
 if(g_satir==(satir-1)){
    while(sayac<satir*sutun-sutun+g_sutun){
        giris=giris->next;
        sayac++;
    }
 }

 //printf("%d",giris->data);
if(giris->data==0){
        printf("Buradan giremezsiniz\n");
        exit(0);
    }
if(g_satir>satir || g_sutun>sutun){
    printf("Labirent sinirlari icerisinden giris yapiniz");
}
 }
///-----------------------------------------------------------------------
 void labirent_cikis(int satir , int sutun){

//struct node *cikis=(struct node*)malloc(sizeof(struct node));
   cikis=start;
   int sayac=0,c_satir,c_sutun;
 printf("Labirentte nereden cikilsin (../..)\n");   scanf("%d %d",&c_satir,&c_sutun);
 //printf("%d",start->next->data);
  if(c_satir==0 && c_sutun!=0){ sayac=0;  ///en üstten cikis
    while(sayac<c_sutun){
        cikis=cikis->next;
        sayac++;
    }

    if(cikis->data==0){
        printf("Buradan cikamazsiniz\n");
        exit(0);
    }
  }

 else if(c_sutun==0 && c_satir!=satir-1){ sayac=0;   ///soldan cikis
    while(sayac<(c_satir)*sutun){
        cikis=cikis->next;
        sayac++;

    }
    if(cikis->data==0){
        printf("Buradan cikamazsiniz\n");
        exit(0);
    }
 }

  else if(c_sutun==(sutun-1) && c_satir!=satir-1){sayac=0; ///sa?dan cikis
    while(sayac<(sutun*c_satir)+c_sutun){
        cikis=cikis->next;
        sayac++;
    }
    if(cikis->data==0){
        printf("Buradan cikamazsiniz\n");
        exit(0);
    }
 }

 else if(c_satir==(satir-1) && c_sutun!=0/*&& c_sutun!=sutun-1*/){sayac=0;///alt cikis
    while(sayac<satir*sutun-sutun+c_sutun){
        cikis=cikis->next;
        sayac++;
    }
    if(cikis->data==0){
        printf("Buradan cikamazsiniz\n");
        exit(0);
    }
 }

 printf("%d((%d))",cikis->data,sayac);
/*if(cikis->data==0){
        printf("Buradan cikamazsiniz\n");
        exit(0);
    }*/
if(c_satir>satir || c_sutun>sutun){
    printf("Labirent sinirlari icerisinden cikis yapiniz");
}
 }
void labirent_coz(int satir, int sutun) {
 /// bu kýsým doldurulacak

}

int main(){
    int satir,sutun,i,j,g_satir,g_sutun,c_satir,c_sutun;
 printf("Satir sayisini gir "); scanf("%d",&satir);
 printf("Sutun sayisini gir"); scanf("%d",&sutun);
srand(time(NULL));
 for(i=0; i<satir; i++){
    for(j=0; j<sutun; j++){
      int x=rand()%2;
        ekle(x,satir,sutun);//ekle(x,g_satir,g_sutun,c_satir,c_sutun);
    }
    printf("\n");
 }


labirent_giris(satir,sutun);
labirent_cikis(satir,sutun);
labirent_coz(satir,sutun);

 return 0;
}
