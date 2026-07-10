class Soal9_Propagate {
    public static void main(String[] args){
        try{
            System.out.println(reverse("This is a string"));
        }
        catch(Exception e){
            System.out.println("The String was blank");
        }
        finally{
            System.out.println("All done");
        }
    }

    public static String reverse(String s) throws Exception{
        if(s.length()==0){
            throw new Exception();
        }
        String reverseStr = "";
        for(int i=s.length()-1 ; i>=0 ; --i){
            reverseStr+=s.charAt(i);
        }
        return reverseStr;
    }
}

/* output awal
PS C:\TUGASKULIAH\semester4\tugas10> java Soal9_Propagate
gnirts a si sihT
All done 

output ketika kata "This is a string" di hapus dan dibiarkan kosong, akan masuk ke catch
PS C:\TUGASKULIAH\semester4\tugas10> java Soal9_Propagate      
The String was blank
All done
*/