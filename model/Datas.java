package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datas{

        LocalDate dataInicio;
        LocalDate dataFinal;
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public Datas(String dataInicio, String dataFinal) {
            setDataInicio(dataInicio);
            setDataFinal(dataFinal);
        }

        public void transformarLocalDate(String qualquerData){
            
        }

        public LocalDate getDataInicio() {
            return dataInicio;
        }

        public void setDataInicio(String dataInicio) {
            this.dataInicio = LocalDate.parse(dataInicio, formatacao);
        }

        public LocalDate getDataFinal() {
            return dataFinal;
        }

        public void setDataFinal(String dataFinal) {
            this.dataFinal = LocalDate.parse(dataFinal, formatacao);
        }




        public DateTimeFormatter getFormatacao() {
            return formatacao;
        }




        public void setFormatacao(DateTimeFormatter formatacao) {
            this.formatacao = formatacao;
        }




     }
    
    
   