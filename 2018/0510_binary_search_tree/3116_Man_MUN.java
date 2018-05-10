import java.util.Scanner;

public class Main {
    static class bacteria {
        public int x;
        public int y;
        public int dx;
        public int dy;
    }

    private static int meeting_time(final bacteria bac1, final bacteria bac2) {
        int d1 = Math.max(abs(b1.x-b2.x), abs(b1.y-b2.y));
        int d2 = Math.max(abs(b1.x+b1.dx-b2.x-b2.dx),
                     abs(b1.y+b1.dy-b2.y-b2.dy));
     
        if ( d2 >= d1 || d1%(d1-d2) != 0 ) return -1;
           
        int t = d1 / (d1-d2);
        if ( b1.x + t*b1.dx == b2.x + t*b2.dx &&
             b1.y + t*b1.dy == b2.y + t*b2.dy ) {
           return t;
        }
        
        return -1;
     }

    public static void main(String[] args) {
        final int MAXT = 2000001;
        final int DX[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
        final int DY[] = { 1, 1, 1, 0, -1, -1, -1, 0 };

        Scanner scanner = new Scanner(System.in);
        
    }
}







int main( void ) {
   int n;
   cin >> n;

   vector<bakterija> bakterije(n);
   for( int i = 0; i < n; ++i ) {
      int smjer;
      cin >> bakterije[i].x >> bakterije[i].y >> smjer;
      bakterije[i].dx = DX[smjer-1];
      bakterije[i].dy = DY[smjer-1];
   }

   int max_rang = 0, min_time = 0;
   for( int i=0; i<n; ++i ) {
      ++NOWCOOKIE;
      for( int j=i+1; j<n; ++j ) {
         int t = vrijeme_susreta(bakterije[i], bakterije[j]);
         if ( t == -1 ) continue;
         
         if ( cookie[t] != NOWCOOKIE ) {
            cookie[t] = NOWCOOKIE;
            rang[t] = 2;
         } else ++rang[t];

         if ( rang[t] >  max_rang ||
              rang[t] == max_rang && t < min_time ) {
            max_rang = rang[t];
            min_time = t;
         }
      }
   }

   cout << max_rang << endl;
   cout << min_time << endl;
   return 0;
}
