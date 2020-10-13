package values

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.mylistview.Apparel
import com.example.mylistview.R
import de.hdodenhof.circleimageview.CircleImageView

class ApparelAdapter internal constructor(private val context: Context) : BaseAdapter() {
    internal var apparel = arrayListOf<Apparel>()

    override fun getCount(): Int = apparel.size

    override fun getItem(i: Int): Any = apparel[i]

    override fun getItemId(i: Int): Long = i.toLong()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View? {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_apparel, viewGroup,
                false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val apprl = getItem(position) as Apparel
        viewHolder.bind(apprl)
        return itemView
    }

private inner class ViewHolder internal constructor(view: View) {
    private val txtName: TextView = view.findViewById(R.id.txt_name)
    private val txtDescription: TextView = view.findViewById(R.id.txt_description)
    private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

    internal fun bind(apprl: Apparel) {
        txtName.text = apprl.name
        txtDescription.text = apprl.description
        imgPhoto.setImageResource(apprl.photo)
        }
    }
}